<%@ page import="java.util.*,model.Book" %>
<html>
<head>
  <title>Book List</title>
</head>
<body>
  <h2>Book List</h2>
  <table border="1">
    <tr><th>ID</th><th>Title</th><th>Author</th><th>Price</th></tr>
    <%
      List<Book> books = (List<Book>) request.getAttribute("books");
      for (Book b : books) {
    %>
      <tr>
        <td><%= b.getId() %></td>
        <td><%= b.getTitle() %></td>
        <td><%= b.getAuthor() %></td>
        <td><%= b.getPrice() %></td>
      </tr>
    <%
      }
    %>
  </table>
  <br><a href="index.html">Add New Book</a>
</body>
</html>
