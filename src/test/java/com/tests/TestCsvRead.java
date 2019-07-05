package com.tests;


import com.restapi.manager.PropertiesManager;
import csv_operations.read_csv_into_pojo_jackson.OnlineCourse;
import csv_operations.read_csv_into_pojo_jackson.ReadCsv;
import org.junit.Test;

import java.io.File;
import java.util.List;

import static org.junit.Assert.*;

public class TestCsvRead {
    @Test
    public void testReadingPersonObjectsFromCsvData() throws Exception {
        File csvWithHeader = new File(PropertiesManager.getAppPropertyValueByName("csvFilePath","online_course"));
        List<OnlineCourse> onlineCourses = ReadCsv.readCsvWithHeader(csvWithHeader,OnlineCourse.getOnlineCourse());
        assertEquals("Eugen Paraschiv",onlineCourses.get(0).getAuthor());
    }
}
