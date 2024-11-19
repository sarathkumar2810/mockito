package com.study.mockito.mockito_demo.business;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class SomeBusinessImplMockTest {
	
	@Mock
	private DataService dataService;
	
	@InjectMocks
	private SomeBusinessImpl someBusinessImpl;
	
//	@Test
//	void findTheGreatestFromAllData_basicScenario() {
//		DataService dataServiceMock = mock(DataService.class);
////		dataServiceMock.retriveAllData() => new int[] {25,15,5};
//		when(dataServiceMock.retriveAllData()).thenReturn(new int[] {25,15,5});
//		SomeBusinessImpl businessImpl = new SomeBusinessImpl(dataServiceMock);
//		assertEquals(25, businessImpl.findTheGreatestFromAllData());
//	}

	@Test
	void findTheGreatestFromAllData_basicScenario() {
		when(dataService.retriveAllData()).thenReturn(new int[] {25,15,5});
		assertEquals(25, someBusinessImpl.findTheGreatestFromAllData());
	}
	
	@Test
	void findTheGreatestFromAllData_withOneValue() {
		when(dataService.retriveAllData()).thenReturn(new int[] {35});
		assertEquals(35, someBusinessImpl.findTheGreatestFromAllData());
	}
	
	@Test
	void findTheGreatestFromAllData_EmptyArray() {
		when(dataService.retriveAllData()).thenReturn(new int[] {});
		assertEquals(Integer.MIN_VALUE, someBusinessImpl.findTheGreatestFromAllData());
	}

}