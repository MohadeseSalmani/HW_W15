package Qu_2.service;

import Qu_2.Model.Course;

import java.util.List;

public interface Repository {

    Course add(Course course);
    void delete(int id);
    Course update (int id, String author, int duration);
    List<Course> findAll();
    List<Course> findById(Course id);
    List<Course> findByBrand(Course title);




}
