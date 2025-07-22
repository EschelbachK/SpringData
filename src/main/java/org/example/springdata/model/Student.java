package org.example.springdata.model;

import lombok.With;

@With
public record Student(String id, String name, int age) {}
