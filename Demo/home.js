let products = [
    {id:1,price:200, name:'Ferrari', img:'https://www.mercedes-benz.ro/passengercars/the-brand/jumper-page/design-concept-car/_jcr_content/contentgallerycontainer/par/contentgallery/par/contentgallerytile/image.MQ6.8.20210115093222.jpeg'},
    {id:2,price:100, name:'Mercedes', img:'https://media.vneconomy.vn/images/upload/2022/04/07/mercedes-1-automotor.jpg'},
    {id:3,price:100, name:'Lamboghini', img:'https://congluan-cdn.congluan.vn/files/content/2023/03/09/11-21560338.jpg'},
]
function display() {
    let str="";
    for (let i = 0; i < products.length; i++) {
            str += `
                <tr>
                    <td>${products[i].id}</td>
                    <td>${products[i].name}</td>
                    <td><img src="${products[i].img}" width="300" height="250"/></td>
                    <td>${products[i].price}</td>
                    <td><button type="button" class="btn btn-info" data-toggle="modal" data-target="#modal1" onclick="showEditProduct(${i})">Edit</button></td>
                    <td><button type="button" class="btn btn-danger" onclick="deleteProduct(${i})">Xóa</button></td>
                </tr>
           `
    }
    document.getElementById("show").innerHTML = str;

}
function deleteProduct(index){
    products.splice(index,1)
    display();
}
function createProduct(){
   let idProduct = document.getElementById("id2").value;
   let nameProduct = document.getElementById("name2").value;
   let imgProduct = document.getElementById("img2").value;
   let priceProduct = document.getElementById("price2").value;
   products.push({id: idProduct, name: nameProduct, img: imgProduct,price: priceProduct})
   display();
}

function showEditProduct(index){
    for(let i = 0 ; i<products.length;i++){
        if(products[i].id==products[index].id){
            document.getElementById("id").value=products[i].id;
            document.getElementById("name").value=products[i].name;
            document.getElementById("price").value=products[i].price;
            document.getElementById("img").value=products[i].img;
        }
    }
}

function editProduct(){
    let idProduct = document.getElementById("id").value;
    let nameProduct = document.getElementById("name").value;
    let imgProduct = document.getElementById("img").value;
    let priceProduct = document.getElementById("price").value;
    for (let product of products) {
        if(product.id==idProduct){
            product.name=nameProduct;
            product.img=imgProduct;
            product.price=priceProduct;
        }
    }
    display();
}

display();