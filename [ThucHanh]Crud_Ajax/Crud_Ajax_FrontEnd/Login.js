let user;
function login() {
    let username = document.getElementById("username").value;
    let password = document.getElementById("password").value;
    let account = {username,password};
    $.ajax({
        type: "Post",
        headers: {
            'Content-Type': 'application/json'
        },
        url: "http://localhost:8080/accounts/login",
        data: JSON.stringify(account),
        success: function (data) {
            user = data;
            if(data==""){
                alert("SAI MK")
            }else{
                if(data.role.id==2){
                    alert("Dang nhap thanh cong User")
                    location.href="main-page.html";
                }else{
                    alert("Dang nhap thanh cong ADM")
                }
                localStorage.setItem('user',JSON.stringify(user));

            }
        },
        error: function (err) {
            console.log(err)
        }
    });
}

function createAccount() {
    let username = document.getElementById("userRegister").value;
    let password = document.getElementById("passwordRegister").value;
    let idRole = document.getElementById("roleRegister").value;
    let account = {username,password,role:{id:idRole}}
    // Tạo ra 1 request.
    $.ajax({
        type: "POST",  // kiểu truyền dữ liệu
        headers: {
            'Content-Type': 'application/json' // sử dụng dữ liệu JSON
        },
        url: "http://localhost:8080/accounts/register", // đường dẫn phương thức bên Controller
        data: JSON.stringify(account),     //Dữ liệu truyền đi, dạng chuỗi
        success: function (data) {
            location.href="Login.html"
        },
        error: function (err) {
            console.log(err)
            // lỗi
        }
    });
}
