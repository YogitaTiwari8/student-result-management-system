# Student Result Management System (Java Stream API)

A console-based Java project that demonstrates real-world usage of the **Java Stream API** by managing and analyzing student academic results.

## 💡 Overview

This project models a small classroom of students, each with marks in multiple subjects, and uses Java 8+ Stream API operations to generate a complete result analysis — replacing traditional loop-based logic with clean, functional-style pipelines.

## 🚀 Features / Stream API Concepts Used

| Feature | Stream Operation Used |
|---|---|
| Filter passed students | `filter()` |
| Sort students by average marks | `sorted()` with `Comparator` |
| Find top scorer | `reduce()` and `max()` |
| Group students by grade | `Collectors.groupingBy()` |
| Separate pass/fail students | `Collectors.partitioningBy()` |
| Class average, min, max | `summaryStatistics()` |
| Join names of passed students | `Collectors.joining()` |
| Subject-wise topper | `max()` with custom `Comparator` |
| Sum of all marks (multi-core) | `parallelStream()` |

## 🗂️ Project Structure

```
student-result-system/
├── Student.java                        # Student model with total, average, grade logic
└── StudentResultManagementSystem.java  # Main class with all Stream API operations
```

## 📊 Sample Output

```
========== ALL STUDENTS ==========
Roll No: 1   | Name: Aarav      | Total: 265  | Average: 88.33  | Grade: B
...

========== TOP SCORER ==========
Roll No: 6   | Name: Ananya     | Total: 275  | Average: 91.67  | Grade: A

========== STUDENTS GROUPED BY GRADE ==========
Grade A:
   Roll No: 6   | Name: Ananya ...
```

## 🛠️ Tech Stack

- Java 8+ (Stream API, Lambda Expressions, Collectors)
- No external dependencies — pure core Java

## 📚 Learning Context

Built as a hands-on project while learning **Modern Java features**, applying Stream API concepts (Intermediate Operations, Terminal Operations, Collectors, and Parallel Streams) to a practical use case.

---
⭐ Feel free to fork and extend this with file/DB persistence, more subjects, or a GUI!
