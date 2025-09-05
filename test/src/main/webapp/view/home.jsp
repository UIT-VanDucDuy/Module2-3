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
    <h1>Danh sách hàng hóa</h1>
    <p>${param.mess}</p>

    <div class="container search-box">
        <form class="row g-3 align-items-center d-flex justify-content-center" action="/home?action=search" method="post">
            <div class="col-md-4">
                <input  type="text" class="form-control" name="searchName" placeholder="Search...">
            </div>
            <div class="col-md-2">
                <select class="form-select" name="categoryId">
                    <option value="" selected disabled hidden>-- Chọn loại --</option>
                    <c:forEach var="category" items="${categoryList}" varStatus="status">
                        <option value="${category.getId()}">${category.getName()}</option>
                    </c:forEach>
                </select>
            </div>
            <tfoot>
            <div class="col-md-auto">
                <button type="submit" class="btn btn-primary px-4">Search</button>
            </div>
            </tfoot>

        </form>
    </div>



    <table id="tableProduct" class="table table-dark table-striped">
        <thead>
        <tr>
            <th>STT</th>
            <th>Mã Hàng Hóa</th>
            <th>Tên Hàng Hóa</th>
            <th>Đơn vị tính</th>
            <th>Giá</th>
            <th>Loại hàng hóa</th>
            <th>Ngày thu hoạch</th>
            <th>Chỉnh sửa</th>
            <th>Xoá</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="productDto" items="${productList}" varStatus="status">
            <tr>
                <td>${status.count}</td>
                <td><c:out value="${productDto.getId()}"></c:out></td>
                <td>${productDto.getName()}</td>
                <td>${productDto.getUnit()}</td>
                <td>${productDto.getPrice()}</td>
                <td>${productDto.getType()}</td>
                <td>${productDto.getDate()}</td>

                <td>
                    <button onclick="getInfoUpdate('${productDto.getId()}','${productDto.getName()}','${productDto.getPrice()}','${productDto.getUnit()}','${productDto.getType()}')" data-bs-toggle="modal"
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
        <tfoot>
        <tr>
            <td colspan="9" class="text-end">
                <button data-bs-toggle="modal" data-bs-target="#addUserModal"
                        class="btn btn-primary px-4">Thêm mới+</button>
            </td>
        </tr>
        </tfoot>
    </table>


</div>

<!-- Modal -->
<div class="modal fade" id="deleteModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <form action="/products?action=delete" method="post">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel">Xóa hàng hóa</h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>

                <div class="modal-body">
                    <input hidden="hidden" id="deleteId" name="deleteId">
                    <span>Bạn có muốn xoá hàng hóa </span>
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
                    <h5 class="modal-title" id="updateModalLabel">Chỉnh sửa</h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>

                <div class="modal-body">
                    <span>Chỉnh sửa sản phẩm có Id : </span>
                    <span style="color: red" id="UpdateId"></span><br><br>
                    <label> Tên :</label>
                    <input id="updateName" name="updateName"> <br><br>
                    <label> Đơn vị tính :</label>
                    <input id="updateUnit" name="updateUnit"> <br><br>
                    <label> Giá :</label>
                    <input id="updatePrice" name="updatePrice"> <br><br>
                    <label> Loại hàng hóa :</label>
                    <input id="updateCategory" name="updateCategory">
                </div>

                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Huỷ</button>
                    <button type="submit" class="btn btn-primary">Sửa</button>
                </div>
            </div>
        </form>
    </div>
</div>
<div class="modal fade" id="addUserModal" tabindex="-1" aria-labelledby="addUserModalLabel"
     aria-hidden="true">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <div class="modal-header">
                <h1 class="modal-title fs-5" id="addUserModalLabel">Add User</h1>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>

            <form action="${pageContext.request.contextPath}/admin/users?action=addUser" method="post">
                <div class="modal-body">
                    <div class="row g-3">
                        <div class="col">
                            <div class="mb-3">
                                <label class="me-3 mb-1">Mã hàng hóa: </label>
                                <input type="text" class="form-control" placeholder="MHH-XXXX"
                                       aria-label="Full name" name="name">
                            </div>
                            <div class="mb-3">
                                <label class="me-3 mb-1">Tên hàng hóa: </label>
                                <input type="text" class="form-control" placeholder="Tên hàng hóa ..."
                                       aria-label="Address" name="address">
                            </div>
                            <div class="mb-3">
                                <label class="me-3 mb-1">Đơn vị: </label>
                                <select class="form-select">
                                    <option> Bó</option>
                                    <option> Củ</option>
                                    <option> Bông</option>
                                    <option> Cành</option>
                                </select>
                            </div>
                            <div class="mb-3">
                                <label class="me-3 mb-1">Giá bán: </label>
                                <input type="text" class="form-control" placeholder="Giá bán ..."
                                       aria-label="Address" name="address">
                            </div>
                        </div>
                    </div>
                    <div class="mb-3">
                        <label class="me-3 mb-1">Loại hàng hóa: </label>
                        <select id="addUserMemberType" name="memberTypeId" class="form-select">
                            <c:forEach var="type" items="${categoryList}">
                                <option value="${type.id}">
                                        ${type.name}
                                </option>
                            </c:forEach>
                        </select>
                    </div>
                </div>

                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                    <button type="submit" class="btn btn-primary">Save</button>
                </div>
            </form>

        </div>
    </div>
</div>

<script>
    function getInfoDelete(id, name) {
        document.getElementById("deleteName").innerText = name;
        document.getElementById("deleteId").value = id;
    }
    function getInfoUpdate(id, name,price,unit,category) {
        document.getElementById("UpdateId").innerText = id;
        document.getElementById("updateName").value = name;
        document.getElementById("updatePrice").value = price;
        document.getElementById("updateUnit").value = unit;
        document.getElementById("updateCategory").value = category;
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

<script>
    document.getElementById("productForm").addEventListener("submit", function(e) {
        let isValid = true;
        // Lấy dữ liệu
        let maHH = document.getElementById("maHH").value.trim();
        let tenHH = document.getElementById("tenHH").value.trim();
        let donVi = document.getElementById("donVi").value;
        let gia = document.getElementById("gia").value.trim();
        let loaiHH = document.getElementById("loaiHH").value;

        // Regex cho mã hàng hoá: MHH-XXXX (X = chữ in hoa hoặc số)
        let regexMaHH = /^MHH-[A-Z0-9]{4}$/;
        // Reset lỗi cũ
        document.querySelectorAll(".text-danger").forEach(el => el.textContent = "");

        // Validate
        if (maHH === "" || !regexMaHH.test(maHH)) {
            document.getElementById("errorMaHH").textContent = "Mã hàng hoá phải theo định dạng MHH-XXXX (X là chữ in hoa hoặc số).";
            isValid = false;
        }

        if (tenHH === "") {
            document.getElementById("errorTenHH").textContent = "Tên hàng hoá không được để trống.";
            isValid = false;
        }

        if (donVi === "") {
            document.getElementById("errorDonVi").textContent = "Vui lòng chọn đơn vị tính.";
            isValid = false;
        }

        if (gia === "" || isNaN(gia) || parseInt(gia) < 1000) {
            document.getElementById("errorGia").textContent = "Giá phải là số nguyên dương và ≥ 1000 VNĐ.";
            isValid = false;
        }

        if (loaiHH === "") {
            document.getElementById("errorLoaiHH").textContent = "Vui lòng chọn loại hàng hoá.";
            isValid = false;
        }
        // Nếu có lỗi thì ngăn submit
        if (!isValid) {
            e.preventDefault();
        }
    });

</script>
