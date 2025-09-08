package prog.series.test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import prog.series.Series;
import prog.series.SeriesModel;

import static org.junit.jupiter.api.Assertions.*;

public class SeriesTest {
    private Series series;

    @BeforeEach
    void setup() {
        series = new Series();
        series.addSeriesForTest(new SeriesModel("S100", "Sample", 12, 10));
    }

    @Test
    void TestSearchSeries() {
        assertTrue(series.searchSeries("S100").isPresent());
    }

    @Test
    void TestSearchSeries_SeriesNotFound() {
        assertFalse(series.searchSeries("X999").isPresent());
    }

    @Test
    void TestUpdateSeries() {
        assertTrue(series.updateSeries("S100", "Updated", "14", "12"));
        assertEquals("Updated", series.searchSeries("S100").get().getSeriesName());
    }

    @Test
    void TestDeleteSeries() {
        assertTrue(series.deleteSeries("S100"));
        assertFalse(series.searchSeries("S100").isPresent());
    }

    @Test
    void TestDeleteSeries_SeriesNotFound() {
        assertFalse(series.deleteSeries("ZZZ"));
    }

    @Test
    void TestSeriesAgeRestriction_AgeValid() {
        assertTrue(Series.isAgeValid(10));
    }

    @Test
    void TestSeriesAgeRestriction_SeriesAgeInValid() {
        assertFalse(Series.isAgeValid(25));
    }
}
