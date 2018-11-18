package ohtu;

import java.util.Arrays;

public class Submission {
    private int week;
    private int hours;
    private int[] exercises;
    private String course;

    public void setWeek(int week) {
        this.week = week;
    }

    public int getWeek() {
        return week;
    }

    @Override
    public String toString() {
        return String.format(
                "%s, viikko %d tehtyjä tehtäviä yhteensä %d aikaa kului %d tehdyt tehtävät: %s",
                course, week, excercisesDone(), hours, Arrays.toString(exercises)
                );
    }

    public int getHours() {
        return hours;
    }

    public int excercisesDone() {
        return exercises.length;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    public int[] getExercises() {
        return exercises;
    }

    public void setExercises(int[] exercises) {
        this.exercises = exercises;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }
}