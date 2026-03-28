Trong **Java**, **Interface** là một khái niệm rất quan trọng trong lập trình hướng đối tượng (OOP). Nó giúp bạn **định nghĩa một “bộ quy tắc” (contract)** mà các class khác phải tuân theo.

---

## 1️⃣ Interface là gì?

**Interface** là một kiểu dữ liệu trong Java dùng để khai báo **các phương thức nhưng không có phần thân (body)**.

Nói đơn giản: \
👉 Interface giống như **bản thiết kế**. \
👉 Class nào **implements** interface thì **phải viết code cho các phương thức đó**.

Ví dụ:

```java
interface Animal {
    void sound();   // phương thức không có body
}
```

Class sử dụng interface:

```java
class Dog implements Animal {
    public void sound() {
        System.out.println("Gâu gâu");
    }
}
```

Main:

```java
public class Main {
    public static void main(String[] args) {
        Dog d = new Dog();
        d.sound();
    }
}
```

Kết quả:

```
Gâu gâu
```

---

## 2️⃣ Cú pháp Interface

```java
interface TenInterface {
    // constant
    // abstract method
}
```

Ví dụ:

```java
interface Vehicle {
    void start();
    void stop();
}
```

Class implement:

```java
class Car implements Vehicle {

    public void start() {
        System.out.println("Car started");
    }

    public void stop() {
        System.out.println("Car stopped");
    }
}
```

---

## 3️⃣ Vì sao cần Interface?

Interface giúp:

### ✔ Tạo chuẩn chung cho nhiều class

Ví dụ:

```
Animal
   ↑
Dog
Cat
Bird
```

Interface:

```java
interface Animal {
    void sound();
}
```

Các class:

```java
class Dog implements Animal { ... }
class Cat implements Animal { ... }
class Bird implements Animal { ... }
```

---

### ✔ Hỗ trợ đa hình (Polymorphism)

```java
Animal a = new Dog();
a.sound();
```

Sau này có thể thay bằng:

```java
Animal a = new Cat();
```

Code **không cần sửa nhiều**.

---

### ✔ Java không hỗ trợ đa kế thừa class nhưng hỗ trợ nhiều interface

Ví dụ:

```java
interface Flyable {
    void fly();
}

interface Swimable {
    void swim();
}
```

Class có thể implement nhiều interface:

```java
class Duck implements Flyable, Swimable {

    public void fly() {
        System.out.println("Duck can fly");
    }

    public void swim() {
        System.out.println("Duck can swim");
    }
}
```

---

## 4️⃣ Một số đặc điểm quan trọng của Interface

| Đặc điểm                | Giải thích                        |
| ----------------------- | --------------------------------- |
| Method                  | Mặc định là `public abstract`     |
| Variable                | Mặc định là `public static final` |
| Không có constructor    | Không thể tạo object trực tiếp    |
| Class dùng `implements` | Không dùng `extends`              |

---

## 5️⃣ Interface vs Abstract Class

| Interface                   | Abstract Class           |
| --------------------------- | ------------------------ |
| Chỉ khai báo method         | Có thể có method có body |
| Không có biến thường        | Có biến instance         |
| Hỗ trợ multiple inheritance | Không hỗ trợ             |

---

## 6️⃣ Ví dụ thực tế dễ hiểu

Interface giống như **ổ cắm điện**.

Ổ cắm quy định:

```
phải có 2 chân
```

Nhưng:

* Laptop
* Quạt
* Sạc điện thoại

👉 mỗi thiết bị **cài đặt cách hoạt động khác nhau**.

---

💡 **Tóm tắt ngắn gọn**

Interface:

* Là **bản thiết kế**
* Chỉ định nghĩa **method**
* Class dùng **implements**
* Hỗ trợ **đa hình và multiple inheritance**

Ok, mình viết cho bạn **một ví dụ FULL từ A → Z** để bạn thấy rõ:

* Interface
* implements
* extends
* dùng thực tế

---

# 🔥 Ví dụ hoàn chỉnh: Quản lý động vật

## 1️⃣ Tạo Interface

```java
interface Animal {
    void eat();
    void makeSound();
}
```

```java
interface Pet {
    void play();
}
```

👉 Đây chỉ là **“bản cam kết”**, chưa có code bên trong.

---

## 2️⃣ Class implement Interface

```java
class Dog implements Animal, Pet {

    public void eat() {
        System.out.println("Dog is eating");
    }

    public void makeSound() {
        System.out.println("Dog says: Gâu gâu");
    }

    public void play() {
        System.out.println("Dog is playing");
    }
}
```

---

## 3️⃣ Class khác implement cùng Interface

```java
class Cat implements Animal, Pet {

    public void eat() {
        System.out.println("Cat is eating");
    }

    public void makeSound() {
        System.out.println("Cat says: Meo meo");
    }

    public void play() {
        System.out.println("Cat is playing");
    }
}
```

---

## 4️⃣ Interface kế thừa Interface (extends)

```java
interface SmartAnimal extends Animal {
    void think();
}
```

---

## 5️⃣ Class implement interface đã kế thừa

```java
class Human implements SmartAnimal {

    public void eat() {
        System.out.println("Human eating");
    }

    public void makeSound() {
        System.out.println("Human talking");
    }

    public void think() {
        System.out.println("Human thinking...");
    }
}
```

---

## 6️⃣ Main chạy chương trình

```java
public class Main {
    public static void main(String[] args) {

        // dùng Dog
        Animal dog = new Dog();
        dog.eat();
        dog.makeSound();

        // dùng Cat
        Animal cat = new Cat();
        cat.makeSound();

        // dùng Pet
        Pet pet = new Dog();
        pet.play();

        // dùng SmartAnimal
        SmartAnimal human = new Human();
        human.think();
    }
}
```

---

# 🎯 Output

```text
Dog is eating
Dog says: Gâu gâu
Cat says: Meo meo
Dog is playing
Human thinking...
```

---

# 🧠 Giải thích cực quan trọng

## 👉 1. Vì sao viết thế này?

```java
Animal dog = new Dog();
```

Không viết:

```java
Dog dog = new Dog();
```

👉 Vì:

* Sau này có thể thay `Dog` bằng `Cat`, `Bird`
* Code **linh hoạt hơn**

---

## 👉 2. Một object có nhiều “vai trò”

```java
Dog d = new Dog();
```

Có thể dùng như:

```java
Animal a = d;
Pet p = d;
```

👉 1 object nhưng dùng theo nhiều interface

---

## 👉 3. Interface = khả năng

| Interface   | Ý nghĩa       |
| ----------- | ------------- |
| Animal      | biết ăn, kêu  |
| Pet         | biết chơi     |
| SmartAnimal | biết suy nghĩ |

---

# ✅ Tóm tắt

Trong ví dụ này có thể thấy:

✔ `implements` → class dùng interface \
✔ `extends` → interface kế thừa interface \
✔ 1 class implement nhiều interface \
✔ polymorphism (Animal dog = new Dog())

---
