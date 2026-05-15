Dưới đây là checklist toàn bộ Lab 04 để bạn tự kiểm tra đã hoàn thành chưa. Mình đã đọc lại lab: lab yêu cầu làm các bài Swing cơ bản trong `GUIProject`, sau đó làm GUI cho AIMS Store Manager trong `AimsProject`, cuối cùng cập nhật diagram và nộp lên branch `release/lab04`. 

# Checklist Lab 04 — GUI Programming with Swing

## A. Chuẩn bị project và package

### 1. `GUIProject` cho phần luyện Swing cơ bản

* [ ] Đã tạo project riêng tên `GUIProject`.
* [ ] Đã tạo package:

```java
hust.soict.hedspi.swing
```

Lưu ý: trong PDF ghi `hust.soict.dsai.swing`, nhưng vì bạn là HEDSPI nên đổi `dsai` thành `hedspi`. 

---

### 2. `AimsProject` cho phần AIMS GUI

* [ ] Không gộp `GUIProject` vào `AimsProject`.
* [ ] Trong project AIMS cũ, đã tạo package:

```java
hust.soict.hedspi.aims.screen.manager
```

Trong PDF ghi `hust.soict.dsai.aims.screen.manager`, nhưng với bạn phải đổi thành `hedspi`. 

---

# B. Phần 1 — Swing components

## 1.1 `AWTAccumulator`

* [ ] Đã tạo class `AWTAccumulator`.
* [ ] Class kế thừa `Frame`.
* [ ] Có 2 `TextField`: `tfInput`, `tfOutput`.
* [ ] Có biến `sum`.
* [ ] Dùng `GridLayout(2, 2)`.
* [ ] Khi nhập số vào `tfInput` rồi nhấn Enter:

  * [ ] parse số vừa nhập
  * [ ] cộng vào `sum`
  * [ ] xóa input
  * [ ] cập nhật `tfOutput`
* [ ] Có `main()` để chạy thử.

Nội dung này nằm ở mục 1.1 trong lab. 

---

## 1.2 `SwingAccumulator`

* [ ] Đã tạo class `SwingAccumulator`.
* [ ] Class kế thừa `JFrame`.
* [ ] Có 2 `JTextField`: `tfInput`, `tfOutput`.
* [ ] Có biến `sum`.
* [ ] Có dùng:

```java
Container cp = getContentPane();
```

* [ ] Add component vào `contentPane`, không add trực tiếp vào `JFrame`.
* [ ] Dùng `GridLayout(2, 2)`.
* [ ] Khi nhập số vào `tfInput` rồi nhấn Enter:

  * [ ] parse số
  * [ ] cộng vào `sum`
  * [ ] xóa input
  * [ ] cập nhật `tfOutput`
* [ ] Có `main()` để chạy thử.

Phần lab nhấn mạnh Swing dùng `JFrame`, component phải đưa vào `contentPane`. 

---

## 1.3 So sánh Swing và AWT

Trong `answers.txt`, bạn nên có câu trả lời cho phần này.

* [ ] Đã so sánh top-level container:

  * AWT: `Frame`
  * Swing: `JFrame`
* [ ] Đã so sánh component:

  * AWT: `Label`, `TextField`, `Button`
  * Swing: `JLabel`, `JTextField`, `JButton`
* [ ] Đã so sánh cách add component:

  * AWT: có thể add trực tiếp vào `Frame`
  * Swing: nên add vào `contentPane`
* [ ] Đã so sánh event-handling:

  * Cả hai đều dùng listener như `ActionListener`
* [ ] Đã ghi nhận giao diện AWT và Swing có thể nhìn khác nhau.

Lab yêu cầu viết phần so sánh này ở mục 1.3. 

---

# C. Phần 2 — Layout Managers

## 2.1 Hiểu container

Bạn không nhất thiết phải code riêng phần này, nhưng nên hiểu và có thể ghi ngắn trong `answers.txt`.

* [ ] Hiểu top-level container:

  * `JFrame`
  * `JDialog`
  * `JApplet`
* [ ] Hiểu secondary-level container:

  * thường dùng `JPanel`
* [ ] Hiểu `JPanel` dùng để gom nhóm component và layout.

Lab giải thích phần này ở mục 2.1. 

---

## 2.2 `NumberGrid`

* [ ] Đã tạo class `NumberGrid`.
* [ ] Class kế thừa `JFrame`.
* [ ] Có mảng:

```java
private JButton[] btnNumbers = new JButton[10];
```

* [ ] Có nút:

```java
private JButton btnDelete, btnReset;
```

* [ ] Có display:

```java
private JTextField tfDisplay;
```

* [ ] `tfDisplay` nằm phía trên.
* [ ] Các nút nằm trong `JPanel panelButtons`.
* [ ] `panelButtons` dùng:

```java
new GridLayout(4, 3)
```

* [ ] `contentPane` dùng:

```java
new BorderLayout()
```

* [ ] Display add vào `BorderLayout.NORTH`.
* [ ] Panel nút add vào `BorderLayout.CENTER`.
* [ ] Có method `addButtons(JPanel panelButtons)`.
* [ ] Các nút từ `1` đến `9` được add trước.
* [ ] Sau đó add `DEL`, `0`, `C`.
* [ ] Các nút dùng chung một `ButtonListener`.

Phần này nằm ở mục 2.2.1 và 2.2.2. 

---

## 2.2.3 Hoàn thiện `ButtonListener`

Trong `NumberGrid`, kiểm tra:

* [ ] Bấm nút số thì nối số vào cuối display.
* [ ] Bấm `DEL` thì xóa ký tự cuối.
* [ ] Nếu display đang rỗng mà bấm `DEL` thì không lỗi.
* [ ] Bấm `C` thì xóa toàn bộ display.
* [ ] Có `main()` để chạy thử.

Lab yêu cầu bạn tự hoàn thiện hai case còn lại: `DEL` và `C`. 

---

# D. Phần 3 — AIMS GUI với Swing

## 3.0 Yêu cầu chung của AIMS GUI

* [ ] Hiểu từ lab này AIMS chia thành 2 ứng dụng:

  * Store Manager
  * Customer
* [ ] Lab 04 chỉ làm phần Store Manager.
* [ ] Customer sẽ làm ở lab sau.
* [ ] Code Store Manager đặt trong:

```java
hust.soict.hedspi.aims.screen.manager
```

PDF ghi `dsai`, bạn đổi thành `hedspi`. 

---

# E. Phần 3.1 — View Store Screen

## 3.1.1 `StoreManagerScreen`

* [ ] Đã tạo class `StoreManagerScreen`.
* [ ] Nên cho class kế thừa `JFrame`.
* [ ] Có thuộc tính:

```java
private Store store;
```

* [ ] Constructor nhận tham số:

```java
public StoreManagerScreen(Store store)
```

* [ ] Gán:

```java
this.store = store;
```

Lab yêu cầu `StoreManagerScreen` có thuộc tính `Store store` để lấy item trong store ra hiển thị. 

---

## 3.1.2 NORTH component

Trong `StoreManagerScreen`:

* [ ] Có method:

```java
JPanel createNorth()
```

* [ ] `createNorth()` tạo `JPanel north`.
* [ ] `north` dùng:

```java
new BoxLayout(north, BoxLayout.Y_AXIS)
```

* [ ] `north` add:

  * [ ] `createMenuBar()`
  * [ ] `createHeader()`

Lab yêu cầu phần `NORTH` chứa menu bar và header. 

---

## 3.1.2 `createMenuBar()`

* [ ] Có method:

```java
JMenuBar createMenuBar()
```

* [ ] Có menu cha:

```java
Options
```

* [ ] Có item:

```java
View store
```

* [ ] Có menu con:

```java
Update Store
```

* [ ] Trong `Update Store` có:

  * [ ] `Add Book`
  * [ ] `Add CD`
  * [ ] `Add DVD`
* [ ] `JMenuBar` dùng `FlowLayout.LEFT`.

Menu trong lab có cấu trúc `Options → View store / Update Store → Add Book, Add CD, Add DVD`. 

---

## 3.1.2 `createHeader()`

* [ ] Có method:

```java
JPanel createHeader()
```

* [ ] Tạo label:

```java
AIMS
```

* [ ] Font cỡ khoảng `50`.
* [ ] Màu chữ `Color.CYAN`.
* [ ] Header dùng:

```java
new BoxLayout(header, BoxLayout.X_AXIS)
```

* [ ] Có dùng `Box.createRigidArea(...)`.
* [ ] Có dùng `Box.createHorizontalGlue()`.

Phần này nằm ở page 13 của lab. 

---

## 3.1.3 CENTER component

* [ ] Có method:

```java
JPanel createCenter()
```

* [ ] Tạo `JPanel center`.
* [ ] `center` dùng:

```java
new GridLayout(3, 3, 2, 2)
```

* [ ] Lấy danh sách media từ store:

```java
store.getItemsInStore()
```

* [ ] Với mỗi media, tạo:

```java
new MediaStore(media)
```

* [ ] Add từng `MediaStore` vào `center`.
* [ ] Nên sửa an toàn hơn code gốc bằng cách duyệt tối đa `Math.min(mediaInStore.size(), 9)` để tránh lỗi khi store có ít hơn 9 item.

Lab gốc dùng 9 item đầu tiên trong store để hiển thị dạng lưới 3x3. 

---

## 3.1.4 `MediaStore`

* [ ] Đã tạo class `MediaStore`.
* [ ] Class kế thừa `JPanel`.
* [ ] Có thuộc tính:

```java
private Media media;
```

* [ ] Constructor nhận:

```java
public MediaStore(Media media)
```

* [ ] Layout của `MediaStore` là:

```java
new BoxLayout(this, BoxLayout.Y_AXIS)
```

* [ ] Có `JLabel` hiển thị title:

```java
media.getTitle()
```

* [ ] Có `JLabel` hiển thị cost:

```java
media.getCost() + " $"
```

* [ ] Title và cost được căn giữa.
* [ ] Có `JPanel container` chứa button.
* [ ] Nếu media là `Playable` thì tạo nút:

```java
Play
```

* [ ] Có border đen quanh mỗi ô:

```java
BorderFactory.createLineBorder(Color.BLACK)
```

Lab lưu ý `MediaStore` kiểm tra `media instanceof Playable` để tạo nút `Play`. 

---

## 3.1.5 Constructor hoàn chỉnh và main

Trong `StoreManagerScreen`:

* [ ] Constructor dùng:

```java
Container cp = getContentPane();
```

* [ ] `cp` dùng:

```java
new BorderLayout()
```

* [ ] Add:

```java
cp.add(createNorth(), BorderLayout.NORTH);
cp.add(createCenter(), BorderLayout.CENTER);
```

* [ ] Có:

```java
setTitle("Store");
setSize(1024, 768);
setLocationRelativeTo(null);
setVisible(true);
```

* [ ] Nên thêm:

```java
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
```

* [ ] Có `main()` để chạy ứng dụng Store Manager.
* [ ] Trong `main()`, có tạo `Store`, thêm dữ liệu mẫu, rồi gọi:

```java
new StoreManagerScreen(store);
```

Lab yêu cầu thêm `main method` để khởi động ứng dụng Store Manager. 

---

# F. Phần 3.2 — Update Store Screen

## 3.2.1 Xử lý menu bar

* [ ] Các menu item không chỉ hiển thị, mà có `ActionListener`.
* [ ] Click `Add Book` mở màn hình thêm Book.
* [ ] Click `Add CD` mở màn hình thêm CD.
* [ ] Click `Add DVD` mở màn hình thêm DVD.
* [ ] Click `View store` quay về màn hình `StoreManagerScreen`.
* [ ] Các màn hình Add item cũng có menu bar giống View Store Screen.

Lab yêu cầu khi click item trong `Update Store`, ứng dụng chuyển sang màn hình thêm item phù hợp; khi click `View store`, quay lại View Store Screen. 

---

## 3.2.2 Các class màn hình thêm item

Lab gợi ý tạo các class này:

* [ ] `AddItemToStoreScreen`
* [ ] `AddBookToStoreScreen`
* [ ] `AddCompactDiscToStoreScreen`
* [ ] `AddDigitalVideoDiscToStoreScreen`

Trong đó:

* [ ] `AddItemToStoreScreen` là class cha.
* [ ] 3 class còn lại kế thừa `AddItemToStoreScreen`.
* [ ] Dùng kế thừa để tránh viết lại menu bar và header nhiều lần.

Lab gợi ý áp dụng inheritance vì các GUI class này chia sẻ một phần giao diện. 

---

## 3.2.3 Add Book screen

* [ ] Có màn hình/form nhập thông tin Book.
* [ ] Có các input cần thiết, ví dụ:

  * [ ] title
  * [ ] category
  * [ ] cost
  * [ ] author/authors
* [ ] Có nút `Add Book`.
* [ ] Khi bấm `Add Book`:

  * [ ] tạo object `Book`
  * [ ] thêm author nếu có
  * [ ] gọi `store.addMedia(book)`
  * [ ] quay về `StoreManagerScreen`
* [ ] Chưa cần validate kiểu dữ liệu.

Lab nói màn hình Add item chưa cần data type validation. 

---

## 3.2.4 Add DVD screen

* [ ] Có màn hình/form nhập thông tin DVD.
* [ ] Có các input cần thiết, ví dụ:

  * [ ] title
  * [ ] category
  * [ ] director
  * [ ] length
  * [ ] cost
* [ ] Có nút `Add DVD`.
* [ ] Khi bấm `Add DVD`:

  * [ ] tạo object `DigitalVideoDisc`
  * [ ] gọi `store.addMedia(dvd)`
  * [ ] quay về `StoreManagerScreen`
* [ ] Chưa cần validate kiểu dữ liệu.

---

## 3.2.5 Add CD screen

* [ ] Có màn hình/form nhập thông tin CD.
* [ ] Có các input cần thiết, ví dụ:

  * [ ] title
  * [ ] category
  * [ ] director
  * [ ] length
  * [ ] cost
  * [ ] artist
* [ ] Có nút `Add CD`.
* [ ] Khi bấm `Add CD`:

  * [ ] tạo object `CompactDisc`
  * [ ] gọi `store.addMedia(cd)`
  * [ ] quay về `StoreManagerScreen`
* [ ] Chưa cần validate kiểu dữ liệu.
* [ ] Nếu project của bạn có quản lý `Track`, có thể thêm sau; lab không bắt buộc rõ phần track trong đoạn này.

---

## 3.2.6 Xử lý nút Play

* [ ] Trong `MediaStore`, nút `Play` không chỉ hiển thị mà có `ActionListener`.
* [ ] Khi click `Play`, mở dialog bằng `JDialog` hoặc `JOptionPane`.
* [ ] Nếu `media instanceof Playable`, ép kiểu:

```java
Playable playable = (Playable) media;
```

* [ ] Gọi:

```java
playable.play();
```

* [ ] Hiển thị thông tin play trong dialog.

Lab yêu cầu khi click nút `Play`, media được play trong dialog window và có thể dùng `JDialog`. 

---

## 3.2.7 Những thứ không cần làm ở lab này

* [ ] Không cần làm Customer application.
* [ ] Không cần làm Add to cart.
* [ ] Không cần làm cart GUI.
* [ ] Không cần làm Remove item from store.
* [ ] Không cần validation dữ liệu nhập.
* [ ] Không cần làm giao diện quá đẹp, chỉ cần đúng chức năng.

Lab nói Customer sẽ làm ở lab sau, remove item bị bỏ qua, và Add item screen chưa cần validate dữ liệu.  

---

# G. `answers.txt`

Lab yêu cầu viết câu trả lời cho các câu hỏi vào file `answers.txt`. 

* [ ] Có file:

```text
answers.txt
```

* [ ] Trong file có trả lời phần so sánh AWT và Swing.
* [ ] Nên có thêm ghi chú ngắn về:

  * container/component
  * top-level/secondary-level container
  * content pane
  * layout manager nếu muốn chắc chắn hơn.

---

# H. UML và Design

Sau khi hoàn thành lab:

* [ ] Cập nhật use case diagram của AIMS.
* [ ] Cập nhật class diagram của AIMS.
* [ ] File `.astah` mới nằm trong thư mục `Design`.
* [ ] File ảnh `.png` mới nằm trong thư mục `Design`.
* [ ] Diagram có thêm các class GUI mới, ví dụ:

  * `StoreManagerScreen`
  * `MediaStore`
  * `AddItemToStoreScreen`
  * `AddBookToStoreScreen`
  * `AddCompactDiscToStoreScreen`
  * `AddDigitalVideoDiscToStoreScreen`
* [ ] Class diagram thể hiện quan hệ kế thừa:

  * `AddBookToStoreScreen extends AddItemToStoreScreen`
  * `AddCompactDiscToStoreScreen extends AddItemToStoreScreen`
  * `AddDigitalVideoDiscToStoreScreen extends AddItemToStoreScreen`
* [ ] Diagram thể hiện liên hệ với `Store`, `Media`, `Playable` nếu cần.

Lab yêu cầu cập nhật use case diagram và class diagram, đồng thời update file `.astah` và `.png` trong thư mục `Design`.  

---

# I. Git và nộp bài

* [ ] Đang ở branch:

```bash
release/lab04
```

* [ ] Đã add source code cần thiết.
* [ ] Đã kiểm tra `.gitignore` để không commit file build như:

  * `bin/`
  * `.class`
  * IDE metadata không cần thiết
* [ ] Đã commit code.
* [ ] Đã push lên repository hợp lệ.
* [ ] Deadline cuối là 10 PM sau 4 ngày kể từ buổi lab.
* [ ] Có nộp phần đã làm ngay sau buổi lab nếu lớp yêu cầu.

Lab yêu cầu push toàn bộ phần làm được lên branch `release/lab04`. 

---

# Checklist rút gọn để tự tick nhanh

```text
[ ] GUIProject
    [ ] package hust.soict.hedspi.swing
    [ ] AWTAccumulator chạy được
    [ ] SwingAccumulator chạy được
    [ ] NumberGrid chạy được
    [ ] DEL và C hoạt động đúng

[ ] answers.txt
    [ ] So sánh AWT và Swing
    [ ] Ghi câu trả lời các câu hỏi trong lab

[ ] AimsProject
    [ ] package hust.soict.hedspi.aims.screen.manager
    [ ] StoreManagerScreen
    [ ] MediaStore
    [ ] View Store Screen hiển thị được store
    [ ] Menu Options có View store, Add Book, Add CD, Add DVD
    [ ] AddItemToStoreScreen class cha
    [ ] AddBookToStoreScreen
    [ ] AddCompactDiscToStoreScreen
    [ ] AddDigitalVideoDiscToStoreScreen
    [ ] Click menu chuyển màn hình đúng
    [ ] Add Book thêm được vào store
    [ ] Add CD thêm được vào store
    [ ] Add DVD thêm được vào store
    [ ] Click Play mở dialog và gọi play()

[ ] Design
    [ ] Update use case diagram
    [ ] Update class diagram
    [ ] Có file .astah mới
    [ ] Có file .png mới

[ ] Git
    [ ] Đang ở branch release/lab04
    [ ] Không commit bin/ và .class
    [ ] Commit code
    [ ] Push lên remote
```

Mức tối thiểu để coi là hoàn thành lab: **NumberGrid xong, StoreManagerScreen hiển thị được, Add Book/CD/DVD hoạt động, Play mở dialog, có answers.txt, cập nhật diagram, push branch `release/lab04`**.
