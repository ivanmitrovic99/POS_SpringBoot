var total=0;
var counter=1;
function addRow() {
	let id= document.getElementById("product_id").value;
	let name = document.getElementById("product_name").value;
	let price = document.getElementById("product_price").value;
	let uom = document.getElementById("product_uom").value;
	let exp_date = document.getElementById("product_expdate").value;
	let tax_symbol = document.getElementById("product_taxsymbol").value;
	let tax_rate = document.getElementById("product_taxrate").value;
	let quantity = document.getElementById("quantity").value;
	let table = document.getElementById("table");
	
	
	//document.getElementById("products").innerHTML ="e";
  document.getElementById("products").innerHTML += "<tr><td>"+id+"</td><td>"+name+"</td> <td>"+price+"</td><td>"+uom+"</td><td>"+exp_date+"</td><td>"+tax_symbol+"</td><td>"+tax_rate+"</td><td>"+quantity+"</td><td><button type='button'  class='btn-danger' onclick='removeRow(this)'>Obrisi</button></td></tr>";
	total=0;
	counter++;
  	for (var i = 1; i < table.rows.length; i++) {
  
  var kol=parseFloat(table.rows[i].cells[7].innerHTML);
  var cena=parseFloat(table.rows[i].cells[2].innerHTML);
  total=total+cena*kol;
   document.getElementById("totalprice").innerHTML=total;
  localStorage.setItem("total",total);
  }
  
  
  localStorage.setItem("data",document.getElementById("products").innerHTML);
  
  }
  
  function onLoad(){
	var oldData=localStorage.getItem("data");
	 document.getElementById("products").innerHTML=oldData;
	
   document.getElementById("totalprice").innerHTML=localStorage.getItem("total");
  
}
  function onLoad1(){
	localStorage.clear();
	
}

function showAddPost(){
	document.getElementById("post-container").style.display="block";
}

function onLoadPurchases(){
let table = document.getElementById("table");
	for (var i = 1; i < table.rows.length; i++) {
  
  var total=parseFloat(table.rows[i].cells[7].innerHTML);
  if(total<0){table.rows[i].cells[8].innerHTML="<button type='button'  class='btn-secondary' >Stornirano</button>"}
 

  }
  
}

function pay(){
	localStorage.clear();
}

function customerSave(){
let products = document.getElementById("purchase_products");
let quantities = document.getElementById("purchase_quantity");
var today = new Date();
var time= new Date();
var dd = String(today.getDate()).padStart(2, '0');
var mm = String(today.getMonth() + 1).padStart(2, '0'); 
var yyyy = today.getFullYear();
var hh = String(today.getHours()).padStart(2, '0');
var mins = String(today.getMinutes()).padStart(2, '0');
today = dd + '/' + mm + '/' + yyyy;
time = hh + ':' + mins;
for (var i = 1; i < table.rows.length; i++) {
  
  products.value+=table.rows[i].cells[0].innerHTML + " ";
  quantities.value+=table.rows[i].cells[7].innerHTML + " ";
  }
document.getElementById("purchase_cashierid").value = document.getElementById("cashier_id").innerHTML;
document.getElementById("purchase_date").value=today;
document.getElementById("purchase_time").value=time;
document.getElementById("purchase_customerid").value=document.getElementById("customerAdded_id").innerHTML.match(/\d+/g);
document.getElementById("purchase_total").value=document.getElementById("totalprice").innerHTML;

}

function removeRow(r){
var i = r.parentNode.parentNode.rowIndex;

document.getElementById('table').deleteRow(i);

total=0;
	counter++;
  	for (var i = 1; i < table.rows.length; i++) {
  
  var kol=parseFloat(table.rows[i].cells[7].innerHTML);
  var cena=parseFloat(table.rows[i].cells[2].innerHTML);
  total=total+cena*kol;}
   document.getElementById("totalprice").innerHTML=total;
  localStorage.setItem("total",total);

}

