### Difference Between Class and Interface in Java

This article explains the differences between **classes** and **interfaces** in Java. Both concepts form the foundation of Object-Oriented Programming (OOP) and play a vital role in defining object behaviors. Let’s dive into the detailed comparison, examples, and key points.

---

### **Table of Contents**
1. [What is a Class?](#what-is-a-class)
2. [Example of a Class](#example-of-a-class)
3. [What is an Interface?](#what-is-an-interface)
4. [Example of an Interface](#example-of-an-interface)
5. [Key Differences Between Class and Interface](#key-differences-between-class-and-interface)
6. [Conclusion](#conclusion)

---

### **What is a Class?**
A **class** is a user-defined prototype or blueprint for creating objects. It includes properties (fields) and behaviors (methods) shared by all objects of the same type.

#### **Components of a Class**
- **Modifiers**: A class can be `public` or have default access.
- **Class Name**: The name should start with an uppercase letter.
- **Superclass**: The class it inherits from (using `extends` keyword).
- **Interfaces**: Interfaces implemented by the class (using `implements` keyword).
- **Body**: Code enclosed within `{ }`.

---

### **Example of a Class**
```java
public class Shikshaonline {
    int x = 5;
}
```

#### Example with Object Creation:
```java
public class Shikshaonline {
    int x = 5;
    
    public static void main(String[] args) {
        Shikshaonline shikshaObj = new Shikshaonline();
        System.out.println(shikshaObj.x);
    }
}
```

---

### **What is an Interface?**
An **interface** is a blueprint that defines a list of methods without their implementation. It is used to specify behaviors an object can perform. Interfaces support multiple inheritance and ensure abstraction.

#### **Key Features of an Interface**
- Methods in an interface are **abstract** (no body) and **public** by default.
- Variables are **static** and **final**.
- Multiple interfaces can be implemented by a class.

---

### **Example of an Interface**
```java
// Interface
interface Animal {
    void animalSound(); // No body
    void sleep();       // No body
}

// Implementing Interface
class Pig implements Animal {
    public void animalSound() {
        System.out.println("The pig says: wee wee");
    }
    public void sleep() {
        System.out.println("Zzz");
    }
}

// Main Method
class Main {
    public static void main(String[] args) {
        Pig myPig = new Pig();
        myPig.animalSound();
        myPig.sleep();
    }
}
```

---

### **Key Differences Between Class and Interface**

| **Parameter**               | **Class**                          | **Interface**                     |
|-----------------------------|------------------------------------|-----------------------------------|
| **Keyword Used**            | `class`                           | `interface`                      |
| **Object Creation**         | Yes                               | No                                |
| **Inheritance from a Class**| Yes                               | No                                |
| **Inheritance by a Class**  | Using `extends`                   | Using `implements`               |
| **Contains Constructors**   | Yes                               | No                                |
| **Abstract Methods**        | No                                | Yes                               |
| **Access Modifiers**         | Can be public, private, protected | Always public                    |
| **Variables**               | Can be static, final, or neither  | Always static and final          |
| **Multiple Inheritance**    | No                                | Yes                               |
| **Final/Static Methods**    | Yes                               | No                                |

---

### **Conclusion**
The main difference between a class and an interface lies in their purpose:
- A **class** describes the **behavior** and **state** of objects.
- An **interface** defines a contract for behaviors, which must be implemented by classes.

