package Qu_2;

import QU_1.Rep.RepositoryCar;
import Qu_2.Model.Content;
import Qu_2.Model.Course;
import Qu_2.Model.Tutorial;
import Qu_2.Rep.RepositoryContent;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {


        RepositoryContent repositoryContent =new RepositoryContent();

        List<Content> contents = new ArrayList<>();
        contents.add(new Course("Java Basics", "Ali", 120, "Beginner", 99));
        contents.add(new Course("Advanced Python", "Reza", 180, "Advanced",150));

        contents.add(new Tutorial("Spring Boot Intro", "Sara", 45, "Spring", true));
        contents.add(new Tutorial("Docker Setup", "Niloofar", 30, "DevOps", false));

        List<Content> content = repositoryContent.findAll();

        List<Tutorial> freeTutorials = content.stream()
                .filter(c -> c instanceof Tutorial && ((Tutorial) c).isFree())
                .map(c -> (Tutorial) c)
                .collect(Collectors.toList());

        List<Course> expensiveCourses = content.stream()
                .filter(c -> c instanceof Course && ((Course) c).getPrice() > 100)
                .map(c -> (Course) c)
                .collect(Collectors.toList());

        int totalDuration = content.stream()
                .mapToInt(Content::getDuration)
                .sum();

        Map<String, Long> authorCount = content.stream()
                .collect(Collectors.groupingBy(Content::getAuthor, Collectors.counting()));


    }
}
