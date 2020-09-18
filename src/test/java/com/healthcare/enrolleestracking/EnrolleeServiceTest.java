package com.healthcare.enrolleestracking;

import com.healthcare.enrolleestracking.exception.ResourceNotFoundException;
import com.healthcare.enrolleestracking.model.Enrollee;
import com.healthcare.enrolleestracking.repository.EnrolleeRepository;
import com.healthcare.enrolleestracking.service.EnrolleeService;
import com.healthcare.enrolleestracking.service.EnrolleeServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.Optional;
import java.util.UUID;
import static junit.framework.TestCase.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class EnrolleeServiceTest {
    @Mock
    private EnrolleeRepository enrolleeRepository;

    @InjectMocks
    private EnrolleeServiceImpl serviceUnderTest;

    @Test
    public void _get() {
        Long id = 1L;
        String name = UUID.randomUUID().toString();
        when(enrolleeRepository.findById(id)).thenReturn(Optional.of(buildEnrollee(id, name)));

        var result = serviceUnderTest.get(id);
        assertEquals(result.getName(), name);
    }

    @Test(expected = ResourceNotFoundException.class)
    public void _get_exception() {
        Long id = 1L;
        when(enrolleeRepository.findById(id)).thenReturn(Optional.empty());

        serviceUnderTest.get(id);
    }

    @Test
    public void _save() {
        Enrollee enrollee = buildEnrollee(1L, "name");

        serviceUnderTest.save(enrollee);

        verify(enrolleeRepository, only()).save(enrollee);
    }

    @Test
    public void _update() {
        Long id = 1L;
        Enrollee enrollee = buildEnrollee(id, "name");
        when(enrolleeRepository.findById(id)).thenReturn(Optional.of(enrollee));

        serviceUnderTest.update(id, enrollee);

        verify(enrolleeRepository).save(enrollee);
    }

    @Test(expected = ResourceNotFoundException.class)
    public void _update_exception() {
        Long id = 1L;
        when(enrolleeRepository.findById(id)).thenReturn(Optional.empty());

        serviceUnderTest.update(id, new Enrollee());
    }

    @Test
    public void _delete() {
        Long id = 1L;
        Enrollee enrollee = buildEnrollee(id, "name");
        when(enrolleeRepository.findById(id)).thenReturn(Optional.of(enrollee));

        serviceUnderTest.delete(id);

        verify(enrolleeRepository).delete(enrollee);
    }

    @Test(expected = ResourceNotFoundException.class)
    public void _delete_exception() {
        Long id = 1L;
        when(enrolleeRepository.findById(id)).thenReturn(Optional.empty());

        serviceUnderTest.delete(id);
    }

    private Enrollee buildEnrollee(Long id, String name) {
        return Enrollee.builder()
                .id(id)
                .name(name)
                .dependentList(new ArrayList<>())
                .build();
    }


}
