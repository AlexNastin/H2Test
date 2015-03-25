var path = "/Supervisor/rest/";
//var path = "/rest/";
var rLogin, rPass;
(function(jQuery) {
    var loaderDivClass = "loadingAll";
    
    function initLoader(){
        if($('.'+loaderDivClass).html()==null){
            $('body').prepend('<div class="'+loaderDivClass+'"><center><img src="images/ajax-loader.gif"/></center></div>');
            $('.'+loaderDivClass).css("height",$(window).height()-25);
            $('head').append('<style>.'+loaderDivClass+' { position: absolute;margin:0;background-color: lightgrey;text-align: center;z-index: 999; top 0; left: 0;opacity:0.4;filter:alpha(opacity=40);display: none;width: 99%; } .'+loaderDivClass+' img{padding-top: 28%;}</style>');
        }
        $("."+loaderDivClass).show();
    }
    
    function prepareOpts(tp, ops){
        options = jQuery.extend(ops, {
            type: tp,
            cache: false,
            headers: {
                "Login":rLogin,
                "Pass":rPass, 
                "Cache-Control": 'no-cache, must-revalidate'
            }
        });
        return options;
    }
 
    function rRead(options)
    {
        initLoader();  
        return jQuery.ajax(prepareOpts("GET", options)).then(function(){
            $("."+loaderDivClass).hide();
        });
    }
   
    function rCreate(options)
    {
        initLoader();  
        return jQuery.ajax(prepareOpts("POST", options)).then(function(){
            $("."+loaderDivClass).hide();
        });
    }
   
    function rUpdate(options)
    {
        initLoader();  
        return jQuery.ajax(prepareOpts("PUT", options)).then(function(){
            $("."+loaderDivClass).hide();
        });
    }
   
    function rDelete(options)
    {
        initLoader();  
        return jQuery.ajax(prepareOpts("DELETE", options)).then(function(){
            $("."+loaderDivClass).hide();
        });
    }
    
    function rComet(options)
    {
        options = jQuery.extend(options, {
            type: "GET",
//            beforeSend: function(req) {
//                req.setRequestHeader("keep-alive", "on");
//                //req.setRequestHeader("Accept", "text/html, */*; q=0.01; application/octet-stream")
//            },
            dataType: "html"
        });
        return jQuery.ajax(options);
    }
    
    
    function log(data)
    {
//        return console.log(data);
    }
   
    $.extend({
        'rCreate': rCreate,
        'rRead': rRead,
        'rUpdate': rUpdate,
        'rDelete': rDelete,
        'rComet': rComet,
        'l': log
    });
   
})(jQuery);

function a(msg, time){
    if(time==null){
        time = 3000;
    }
    elm = $("#msg");
    if(elm.length==0){
        elm = $("<div id='msg'></div>");
    }
    $('body').prepend(elm);
    elm.html(msg);
    elm.show();
    elm.fadeOut(time);
}

