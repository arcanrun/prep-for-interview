package com.arcan.hw07.controller;

import com.arcan.hw07.model.StudentEntity;
import com.arcan.hw07.repository.StudentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@Slf4j
public class StudentController {

    private final StudentRepository studentRepository;

    public StudentController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @GetMapping
    public String indexPage(Model model) {
        model.addAttribute("students", studentRepository.findAll());
        return "index";
    }

    @DeleteMapping("/{id}")
    public String deleteStudent(@PathVariable Integer id) {
        studentRepository.deleteById(id);
        return "redirect:/";
    }

    @PostMapping
    public String addStudent(@ModelAttribute StudentEntity studentEntity) {
        log.info("studentEntity: {}", studentEntity);
        studentRepository.save(studentEntity);
        return "redirect:/";
    }

    @GetMapping("/{id}")
    public String getByid(@PathVariable Integer id, Model model) {
        Optional<StudentEntity> optionalStudentEntity = studentRepository.findById(id);
        if (!optionalStudentEntity.isPresent()) {
            return "redirect:/";
        }
        model.addAttribute("student", optionalStudentEntity.get());
        return "student";
    }

    @PutMapping("/{id}")
    public String updateStudent(@PathVariable Integer id, @ModelAttribute StudentEntity studentEntity){
        studentEntity.setId(id);
        studentRepository.save(studentEntity);
        return "redirect:/";
    }
}
