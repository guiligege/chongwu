$(document).ready(function(){
	//FLEXISLIDER
	jQuery('.flexslider').flexslider({
		animation: "slide",
		start: function(slider){
		  $('body').removeClass('loading');
		  //lazyload
			$('img[data-original]').lazyLoad({
					defaultImage: '../img/o_loading.gif'
					, parents: 'li'
					, timeout: 500
			});
		}
	});
	
	//JCAROUSEL
	jQuery('.first-and-second-carousel').jcarousel();
	
	
	//SLIDE TOGGLE
	jQuery(".minicart_link").toggle(function() {
		 $('.cart_drop').slideDown(300);	
		 }, function(){
		 $('.cart_drop').slideUp(300);		 
	});	
	
	
	//FORM ELEMENTS
	jQuery("select").uniform(); 

});