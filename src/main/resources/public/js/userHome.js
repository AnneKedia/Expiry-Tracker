$(document).ready(function() {

	var userId;
	var productUrl="";
	$.ajax({
		url : '/getLoggedinUser',
		type : 'get',
		success : function(data) {
			document.getElementById("nameContainer").innerHTML = data.username;
			productUrl="/product/user/"+data.userid;
			userId=data.userid;
			$.ajax({
		        url: productUrl,
		        type: 'get',
		        success: function (data) {
		            var i;
		            console.log(data.length);
		            if(data.length==0){
		            	 $("#productCarousel").append("<div class='product-item no-product-title'><h2>No Products Added</h2></div>");
		            }
		            for(i=0;i<data.length;i++){
		            var id=data[i].id;
		            var	name=data[i].name;
		            var	type=data[i].type;
		            var	quantity=data[i].quantity;
		            var	date=data[i].expiry_date;
		            var d = new Date();
		            var date1 = new Date(); 
		            var date2 = new Date(date);  
		            var Difference_In_Time = date2.getTime() - date1.getTime(); 	             
		            var Difference_In_Days = Difference_In_Time / (1000 * 3600 * 24); 
		            var diff=Math.ceil(Difference_In_Days);
		            var diffDays;
		            if(diff<=0){
		            	diffDays="<div class='date-red expired'>EXPIRED!!</div>";
		            } else if(diff<=5){
		            	diffDays="<div class='date-red days-left'>Days Left:"+diff+"</div>";
		            } else if(diff<=15){
		            	diffDays="<div class='date-yellow days-left'>Days Left:"+diff+"</div>";
		            } else {
		            	diffDays="<div class='date-green days-left'>Days Left:"+diff+"</div>";
		            }
		            $("#productCarousel").append("<div class='product-item'><div><img class='product-img' src=images/"+type+".png></div><div class='product-data'><div>Name:"+name+"</div><div>Type:"+type+"</div><div>Quantity:"+quantity+"</div><div>Expiry Date:"+date+"</div>"+diffDays+"</div><div class='product-delete' id='deleteProduct/"+id+"'><i class='fas fa-trash-alt'></i></div></div>");
		            }
		            $('.slick-carousel').slick({
		        		infinite : false,
		        		speed : 300,
		        		slidesToShow : 3,
		        		slidesToScroll : 1,
		        		responsive : [ {
		        			breakpoint : 1024,
		        			settings : {
		        				slidesToShow : 2,
		        				slidesToScroll : 2,
		        				infinite : true,
		        				dots : true
		        			}
		        		}, {
		        			breakpoint : 600,
		        			settings : {
		        				slidesToShow : 1,
		        				slidesToScroll : 1
		        			}
		        		}, {
		        			breakpoint : 480,
		        			settings : {
		        				slidesToShow : 1,
		        				slidesToScroll : 1
		        			}
		        		}
		        		// You can unslick at a given breakpoint now by adding:
		        		// settings: "unslick"
		        		// instead of a settings object
		        		]
		        	});
		            $('.slick-prev').hide();
		            $('.slick-next').hide();
		        },
		        fail:function(){
		        	console.log("fail");
		        }
		    });
			
		}
	});	
	$(document).on("click", ".product-delete" , function() {
		var deleteurl=$(this).attr("id");
		Swal.fire({
			  title: 'Are you sure?',
			  text: "You won't be able to revert this!",
			  icon: 'warning',
			  showCancelButton: true,
			  confirmButtonColor: '#3085d6',
			  cancelButtonColor: '#d33',
			  confirmButtonText: 'Yes, delete it!'
			}).then((result) => {
			  if (result.value) {
					$.ajax({
			            url: deleteurl,
			            type: 'get',
			            success: function (data) {
			            	console.log("deleted");      	
			            	setTimeout(function(){ location.reload(); }, 900);
			            	Swal.fire({
				              	  icon: 'success',
				              	  title: 'Product Deleted',
				              	  showConfirmButton: false,
				              	  timer: 750
				              	});      
			            },
			            fail: function(){
			            	Swal.fire({
			            		  icon: 'error',
			            		  title: 'Oops...',
			            		  text: 'Cannot Delete Right Now!'
			            		})
			            }
					});
			  }
			})
	});
	$("#productForm").submit(function() {
		console.log($("#date").val());
		var splitDate = $("#date").val().split("/");
		//var expirydate = splitDate[2] + "-" + splitDate[0] + "-" +splitDate[1];
		const productFormData = {
			name : $("#name").val(),
			type : $("#type").val(),
			quantity : $("#quantity").val(),
			expiry_date : $("#date").val(),
			userid : userId
		}
		$.ajax({
            url: '/addProduct',
            type: 'post',
            contentType: 'application/json',
            success: function (data) {
            	if(data.id==undefined){
            		Swal.fire({
	            		  icon: 'error',
	            		  title: 'Oops...',
	            		  text: 'Product Already Expired!'
	            		})
            	}else {
                console.log("product added");
                Swal.fire({
              	  icon: 'success',
              	  title: 'Product Added',
              	  showConfirmButton: true,
              	  timer: 1500
              	})
              	location.reload();
            	}
            },
            data: JSON.stringify(productFormData)
        });
		return false;
	});
});