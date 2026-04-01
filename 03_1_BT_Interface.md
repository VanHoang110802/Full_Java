Ok, mình cho bạn bộ bài tập **từ dễ → thực tế → hơi nâng cao**, làm xong là bạn hiểu Interface rất chắc 👌

---

# 🟢 Bài 1 (cơ bản) – Nhận diện khi nào dùng Interface

## 🎯 Yêu cầu

Xem các case sau và trả lời:

👉 **Có nên dùng Interface không? Vì sao?**

---

### Case 1

```id="c1"
Calculator (cộng, trừ, nhân, chia)
```

✅ Không, vì cộng, trừ, nhân, chia -> luôn làm theo 1 cách, Không có nhiều "biến thể"

---

### Case 2

```id="c2"
Thanh toán: Momo, Visa, Bank
```
✅ Có, vì có nhiều cách thực hiện cùng 1 chức năng, Momo -> trừ ví, Visa -> trừ thẻ, Bank -> chuyển khoản. Cùng là pay() nhưng logic khác.

---

### Case 3

```id="c3"
Đọc file: chỉ đọc file .txt
```
✅ Không, vì chỉ có 1 kiểu xử lý 1 file duy nhất. 

---

### Case 4

```id="c4"
Gửi thông báo: Email, SMS, Push Notification
```
✅ Có, vì cùng 1 hành động nhưng nhiều cách thực hiện: Email → gửi qua SMTP, SMS → qua nhà mạng, Push → qua Firebase. Cùng là 1 hàm send(message) nhưng xử lý khác nhau.

---

### Case 5

```id="c5"
Tính diện tích:
- Hình tròn
- Hình vuông
- Hình chữ nhật
```
✅ Có, đây là "1 hàm xử lý nhiều chức năng", tuy cùng 1 hành vi: tính diện tích nhưng mà là nhiều loại đối tượng khác nhau nên dùng interface được.

---

### Case 6

```id="c6"
In báo cáo:
- In ra màn hình
- In ra file PDF
```
✅ Có, vì đây là 1 việc có nhiều cách làm.

---

### Case 7

```id="c7"
UserService:
- thêm user
- sửa user
- xoá user
```
✅ Không, đây là CRUD (create, update, delete), không phải nhiều cách làm, mà là nhiều chức năng khác nhau.

---

### Case 8

```id="c8"
Upload file:
- Upload local
- Upload lên cloud (AWS, Google Drive)
```
✅ Có, Upload local vs cloud = nhiều cách thực hiện

---

### Case 9

```id="c9"
Logger:
- log ra console
```
✅ Không, chỉ có 1 cách là log thôi

---

### Case 10

```id="c10"
Sắp xếp mảng:
- bubble sort
- quick sort
```
✅ Có, đây là có nhiều thuật toán khác nhau nên dùng được

---

### Case 11

```id="c11"
Thanh toán:
- hiện tại chỉ có Momo
```
✅ Không, chỉ có mỗi xử lý momo thôi

---

### Case 12

```id="c12"
Gửi OTP:
- SMS
- Email
```
✅ Có, 1 việc → nhiều cách làm

---

### Case 13

```id="c13"
Database:
- MySQL
```

👉 nhưng tương lai có thể thêm:

```id="c13b"
MongoDB
PostgreSQL
```
✅ Có, vì mỗi cái database khác nhau về cách xử lý

---

### Case 14

```id="c14"
Game:
- Nhân vật có thể:
    + chạy
    + bắn
    + bay (chỉ một số nhân vật)
```
✅ Có, vì có nhiều khả năng khác nhau nên dùng được

---


# 🟡 Bài 2 (code cơ bản)
## Yêu cầu 1: Xây dựng 1 payment có nhiều cách thanh toán, có validate + log + xử lý lỗi nhẹ

[Link ở đây]()

## Yêu cầu 2: Xây dựng 1 chương trình quản lý sinh viên cơ bản bằng Java, trong chương trình có CRUD, tìm kiếm theo tên và lọc những sinh viên có điểm > 5
