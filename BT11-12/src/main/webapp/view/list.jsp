<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
  <title>Title</title>
  <c:import url="../layout/library.jsp"/>
  <!-- DataTables CSS -->
  <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.13.4/css/jquery.dataTables.min.css"/>

  <!-- jQuery -->
  <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>

  <!-- DataTables JS -->
  <script type="text/javascript" src="https://cdn.datatables.net/1.13.4/js/jquery.dataTables.min.js"></script>

</head>
<body>
<c:import url="../layout/header.jsp"/>
<div>
  <h1>Danh sách sinh viên</h1>
  <p>${param.mess}</p>
  <a href="/products?action=add">Thêm mới</a>
  <table id="tableProduct" class="table table-dark table-striped">
    <thead>
    <tr>
      <th>STT</th>
      <th>Tên</th>
      <th>Giá</th>
      <th>Mô tả</th>
      <th>Nhà Sản xuất</th>
      <th>Danh mục sản phẩm</th>
      <th>Chỉnh sửa</th>
      <th>Xoá</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="productDto" items="${productList}" varStatus="status">
      <tr>
        <td>${status.count}</td>
        <td><c:out value="${productDto.getName()}"></c:out></td>
        <td>${productDto.getPrice()}</td>
        <td>${productDto.getDescription()}</td>
        <td>${productDto.getManufacturer()}</td>
        <td>${productDto.getCategory()}</td>

        <td>
          <button onclick="getInfoUpdate('${productDto.getId()}','${productDto.getName()}','${productDto.getPrice()}','${productDto.getManufacturer()}')" data-bs-toggle="modal"
                  data-bs-target="#updateModal" class="btn btn-sm btn-primary">Chỉnh sửa
          </button>
        </td>
        <td>
          <button onclick="getInfoDelete('${productDto.getId()}','${productDto.getName()}')" data-bs-toggle="modal"
                  data-bs-target="#deleteModal" class="btn btn-sm btn-danger">Xoá
          </button>
        </td>
      </tr>
    </c:forEach>
    </tbody>
  </table>
</div>

<!-- Modal -->
<div class="modal fade" id="deleteModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <form action="/products?action=delete" method="post">
      <div class="modal-content">
        <div class="modal-header">
          <h5 class="modal-title" id="exampleModalLabel">Modal title</h5>
          <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
        </div>

        <div class="modal-body">
          <input hidden="hidden" id="deleteId" name="deleteId">
          <span>Bạn có muốn xoá sinh viên </span>
          <span style="color: red" id="deleteName"></span>
          <span> không???</span>
        </div>

        <div class="modal-footer">
          <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Huỷ</button>
          <button type="submit" class="btn btn-primary">Xoá</button>
        </div>
      </div>
    </form>
  </div>
</div>

<div class="modal fade" id="updateModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <form action="/products?action=update" method="post">
      <div class="modal-content">
        <div class="modal-header">
          <h5 class="modal-title" id="updateModalLabel">Modal title</h5>
          <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
        </div>

        <div class="modal-body">
          <span>Chỉnh sửa sản phẩm có Id : </span>
          <span style="color: red" id="UpdateId"></span><br><br>
          <label> Tên :</label>
          <input id="updateName" name="updateName"> <br><br>
          <label> Giá :</label>
          <input id="updatePrice" name="updatePrice"> <br><br>
          <label> Nhà sản xuất :</label>
          <input id="updateManufacturer" name="updateManufacturer">

        </div>

        <div class="modal-footer">
          <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Huỷ</button>
          <button type="submit" class="btn btn-primary">Xoá</button>
        </div>
      </div>
    </form>
  </div>
</div>

<script>
  function getInfoDelete(id, name) {
    document.getElementById("deleteName").innerText = name;
    document.getElementById("deleteId").value = id;
  }
  function getInfoUpdate(id, name,price,manufacturer) {
    document.getElementById("UpdateId").innerText = id;
    document.getElementById("updateName").value = name;
    document.getElementById("updatePrice").value = price;
    document.getElementById("updateManufacturer").value = manufacturer;
  }
  $(document).ready(function() {
    $('#tableProduct').dataTable( {
      "dom": 'lrtip',
      "lengthChange": false,
      "pageLength": 5
    } );
  } );
</script>
</body>
</html>