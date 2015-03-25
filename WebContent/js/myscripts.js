$(document).ready(function() {

	$("#insertFrom").validate({

		rules : {

			idLogin : {
				digits : true,
				required : true,
				minlength : 1
			},

			name : {
				required : true,
				minlength : 2,
			},
			email : {
				required : true,
				minlength : 6,
				maxlength : 16,
			},
			pass : {
				required : true,
				minlength : 6,
				maxlength : 16,
			}
		},
	})
}); // end of ready
