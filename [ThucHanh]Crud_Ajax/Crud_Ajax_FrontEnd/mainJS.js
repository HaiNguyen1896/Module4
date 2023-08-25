let choosenNumber;
function getAll() {
    checkLog();
    // Tạo ra 1 request.
    $.ajax({
        type: "GET",
        headers: {
            'Accept': 'application/json',
        },
        url: "http://localhost:8080/accounts/getall",
        success: function (data) {
            show(data);
        },
        error: function (err) {
            console.log(err)
            // lỗi
        }
    });
}

getAll();

function show(arr) {
    let str = "";
    for (const a of arr) {
        str += ` <tr>
              <td>${a.id}</td>
              <td>${a.username}</td>
              <td>${a.password}</td>
              <td>${a.role.name}</td>
              <td><button type="button" class="btn btn-warning" onclick="showEdit(${a.id})" data-toggle="modal" data-target="#modalEdit">Edit</button></td>
              <td><button type="button" class="btn btn-danger" data-toggle="modal" data-target="#modalEdit" onclick="passID(${a.id})">Delete</button></td>
             </tr>`
    }
    document.getElementById("show").innerHTML = str;
}

function showEdit(idA){
    $.ajax({
        type: "GET",
        headers: {
            'Accept': 'application/json',
        },
        url: "http://localhost:8080/accounts/find/"+idA,
        success: function (data) {
            document.getElementById("idE").value = data.id;
            document.getElementById("usernameE").value = data.username;
            document.getElementById("passwordE").value = data.password;
            document.getElementById("idRoleE").value = data.role.id;
        },
        error: function (err) {
            console.log(err)
        }
    });
}

function findByName(){
    let keyword = document.getElementById("keyword").value
    $.ajax({
        type:"GET",
        headers: {
            'Accept': 'application/json',
        },
        url:"http://localhost:8080/accounts/findByName/"+keyword,
        success: function (arr) {
            show(arr)
    },
    error: function (err) {
        console.log(err)
    }
    });
}

function deleteA(idA){
    $.ajax({
        type: "GET",
        url: "http://localhost:8080/accounts/delete/"+idA,
        success: function (data) {
            getAll();
        },
        error: function (err) {
            console.log(err)
        }
    });
}

function edit() {
    let id = document.getElementById("idE").value;
    let username = document.getElementById("usernameE").value;
    let password = document.getElementById("passwordE").value;
    let idRole = document.getElementById("idRoleE").value;

    let account = {id,username,password,role:{id:idRole}};

    $.ajax({
        type: "Post",
        headers: {
            'Content-Type': 'application/json'
        },
        url: "http://localhost:8080/accounts/edit",
        data: JSON.stringify(account),
        success: function (data) {
            getAll();
        },
        error: function (err) {
            console.log(err)
        }
    });
}
function create() {
    let id = document.getElementById("id").value;
    let username = document.getElementById("username").value;
    let password = document.getElementById("password").value;
    let idRole = document.getElementById("idRole").value;
    let account = {id,username,password,role:{id:idRole}}
    // Tạo ra 1 request.
    $.ajax({
        type: "POST",  // kiểu truyền dữ liệu
        headers: {
            'Content-Type': 'application/json' // sử dụng dữ liệu JSON
        },
        url: "http://localhost:8080/accounts/create", // đường dẫn phương thức bên Controller
        data: JSON.stringify(account),     //Dữ liệu truyền đi, dạng chuỗi
        success: function (data) {
            getAll(); 
        },
        error: function (err) {
            console.log(err)
            // lỗi
        }
    });
}
function passID(index){
    choosenNumber=index;
}
function checkLog(){
    let savedUser = JSON.parse(localStorage.getItem('user'));
    if(savedUser){
        console.log(savedUser)
        if(savedUser.role.id==2){
            $('#createButton').hide();
        }
    }
}