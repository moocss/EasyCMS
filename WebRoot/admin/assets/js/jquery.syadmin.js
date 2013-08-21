(function($) { 
    $.pony = $.pony || {
        version: "v1.0.0"
    };
    $.extend($.pony, {
        util: {
            //根据iframe对象获取iframe的window对象
            getFrameWindow: function (frame) {
                return frame && typeof(frame) === 'object' && frame.tagName === 'IFRAME' && frame.contentWindow;
            },
            //根据iframe对象获取iframe的document对象
            getFrameDocument: function (frame){
                return frame && typeof(frame)=='object' && frame.tagName == 'IFRAME' && frame.contentDocument || frame.contentWindow && frame.contentWindow.document || frame.document;
            },
            //获取url参数名
            getUrlParam: function(paramName){
                var reg = new RegExp("(^|&)"+ paramName +"=([^&]*)(&|$)");
                var r = window.location.search.substr(1).match(reg);
                if (r!=null) return unescape(r[2]); return null;
            },
            //判断是否ie6
            isIE6: function() {
                return ($.browser.msie && $.browser.version=="6.0") ? true : false
            },
            //获取url的get参数, param 要获取的参数名称，如果不传，则返回整个参数对象
            getURLParams: function(param) {
                var params = {};
                var href = /^http/i.test(this) ? this : window.location.toString();
                var uri = href.split("?");
                if (!uri[1])
                    return null;

                uri = uri[1].split("#")[0];

                var paramSet = uri.split("&");
                var temp = [];
                for (index in paramSet) {
                    temp = paramSet[index].split("=");
                    params[temp[0]] = temp[1];
                }

                if (param) {
                    if (params[param])
                        return params[param];
                    else
                        return null;
                } else {
                    return params;
                }
            },
            //去掉首尾空字符
            trim: function(str) {
                return str.replace(/(^\s*)|(\s*$)/g,"");
            },
            //日期格式化
            dateFormat : function(format) {
                var date = new Date();
                if (!format) {
                    format = "yyyy-MM-dd hh:mm:ss";
                }
                var o = {
                    "M+": date.getMonth() + 1,
                    // month
                    "d+": date.getDate(),
                    // day
                    "h+": date.getHours(),
                    // hour
                    "m+": date.getMinutes(),
                    // minute
                    "s+": date.getSeconds(),
                    // second
                    "q+": Math.floor((date.getMonth() + 3) / 3),
                    // quarter
                    "S": date.getMilliseconds()
                            // millisecond
                };

                if (/(y+)/.test(format)) {
                    format = format.replace(RegExp.$1, (date.getFullYear() + "").substr(4 - RegExp.$1.length));
                }

                for (var k in o) {
                    if (new RegExp("(" + k + ")").test(format)) {
                        format = format.replace(RegExp.$1, RegExp.$1.length === 1 ? o[k] : ("00" + o[k]).substr(("" + o[k]).length));
                    }
                }
                return format;
            },
            /* 
            * 将 Date 转化为指定格式的String
            * 
            * 月(M)、日(d)、12小时(h)、24小时(H)、分(m)、秒(s)、周(E)、季度(q) 可以用 1-2 个占位符
            * 
            * 年(y)可以用 1-4 个占位符，毫秒(S)只能用 1 个占位符(是 1-3 位的数字)
            * 
            * datePattern("yyyy-MM-dd hh:mm:ss.S") ==> 2006-07-02 08:09:04.423
            * 
            * datePattern("yyyy-MM-dd E HH:mm:ss") ==> 2009-03-10 二 20:09:04
            * 
            * datePattern("yyyy-MM-dd EE hh:mm:ss") ==> 2009-03-10 周二 08:09:04
            * 
            * datePattern("yyyy-MM-dd EEE hh:mm:ss") ==> 2009-03-10 星期二 08:09:04
            * 
            * datePattern("yyyy-M-d h:m:s.S") ==> 2006-7-2 8:9:4.18
            */
            datePattern : function(fmt) {
                var date = new Date();
                var o = {
                    "M+" : date.getMonth() + 1, /* 月份 */
                    "d+" : date.getDate(), /* 日 */
                    "h+" : date.getHours() % 12 == 0 ? 12 : date.getHours() % 12, /* 小时 */
                    "H+" : date.getHours(), /* 小时 */
                    "m+" : date.getMinutes(), /* 分 */
                    "s+" : date.getSeconds(), /* 秒 */
                    "q+" : Math.floor((date.getMonth() + 3) / 3), /* 季度 */
                    /* 毫秒 */
                    "S" : date.getMilliseconds()
                };
                var week = {
                    "0" : "\u65e5",
                    "1" : "\u4e00",
                    "2" : "\u4e8c",
                    "3" : "\u4e09",
                    "4" : "\u56db",
                    "5" : "\u4e94",
                    "6" : "\u516d"
                };
                if (/(y+)/.test(fmt)) {
                    fmt = fmt.replace(RegExp.$1, (date.getFullYear() + "").substr(4 - RegExp.$1.length));
                }
                if (/(E+)/.test(fmt)) {
                    fmt = fmt.replace(RegExp.$1, ((RegExp.$1.length > 1) ? (RegExp.$1.length > 2 ? "\u661f\u671f" : "\u5468") : "") + week[date.getDay() + ""]);
                }
                for ( var k in o) {
                    if (new RegExp("(" + k + ")").test(fmt)) {
                        fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k]) : (("00" + o[k]).substr(("" + o[k]).length)));
                    }
                }
                return fmt;
            },

            //获取dom对象的当前位置
            getPosition: function(ele){
                var top = ele.offset().top,
                left = ele.offset().left,
                bottom = top + ele.outerHeight(),
                right = left + ele.outerWidth(),
                lmid = left + ele.outerWidth()/2,
                vmid = top + ele.outerHeight()/2;
        
                // iPad position fix
                if (/iPad/i.test(navigator.userAgent)) {
                    top -= $(window).scrollTop();
                    bottom -= $(window).scrollTop();
                    vmid -= $(window).scrollTop();
                }
                var position = {
                    leftTop: function(){
                        return {x: left, y: top};
                    },
                    leftMid: function(){
                        return {x: left, y: vmid};
                    },
                    leftBottom: function(){
                        return {x: left, y: bottom};
                    },
                    topMid: function(){
                        return {x: lmid, y: top};
                    },
                    rightTop: function(){
                        return {x: right, y: top};
                    },
                    rightMid: function(){
                        return {x: right, y: vmid};
                    },
                    rightBottom: function(){
                        return {x: right, y: bottom};
                    },
                    MidBottom: function(){
                        return {x: lmid, y: bottom};
                    },
                    middle: function(){
                        return {x: lmid, y: vmid};
                    }
                };
                return position;
            },
            //获取根域名
            getDomain: function(url){
                var domain = "null";
                var regex = /[a-zA-Z0-9][-a-zA-Z0-9]{0,62}(\.[a-zA-Z0-9][-a-zA-Z0-9]{0,62})+\.?/;
                var match = regex.exec(url);
                if (typeof match != "undefined" && null != match) {
                    domain = match[0];
                }
                return domain;
            },
            openWin: function(url){
                var top=190;
                var whichsns = url.substr(url.lastIndexOf("snsType=")+8,1);
                if(whichsns == 4 || whichsns == 5){
                    var left = document.body.clientWidth > 820 ? (document.body.clientWidth-820)/2 : 0;
                    window.open(url, 'connect_window', 'height=700, width=820, toolbar=no, menubar=no, scrollbars=yes, resizable=no,top='+top+',left='+left+', location=no, status=no');
                }else if(whichsns == 8){
                    var left = (document.body.clientWidth-580)/2;
                    window.open(url, 'connect_window', 'height=620, width=580, toolbar=no, menubar=no, scrollbars=yes, resizable=no,top='+top+',left='+left+', location=no, status=no');
                }else if(whichsns == 9){
                    var left = document.body.clientWidth > 900 ? (document.body.clientWidth-900)/2 : 0;
                    window.open(url, 'connect_window', 'height=550, width=900, toolbar=no, menubar=no, scrollbars=yes, resizable=no,top='+top+',left='+left+', location=no, status=no');
                }else{                                      
                    var left = (document.body.clientWidth-580)/2;
                    window.open(url, 'connect_window', 'height=420, width=580, toolbar=no, menubar=no, scrollbars=yes, resizable=no,top='+top+',left='+left+', location=no, status=no');
                }
        
            }
       
           
        }
    });

})(jQuery);

/*
* 创建标签
*/
function addTab(title, url){
    if ($('#tabs').tabs('exists', title)){
        $('#tabs').tabs('select', title);//选中并刷新
        var currTab = $('#tabs').tabs('getSelected');
        var url = $(currTab.panel('options').content).attr('src');
        if(url != undefined && currTab.panel('options').title != 'Home') {
            $('#tabs').tabs('update',{
                tab:currTab,
                options:{
                    content:createFrame(url)
                }
            })
        }
    } else {
        $('#tabs').tabs('add',{
            title:title,
            content:createFrame(url),
            closable:true
        });
    }
    tabClose();
}

function createFrame(url) {
    var s = '<div id="iframe-wraper"><iframe scrolling="auto" frameborder="0"  src="'+url+'" width="100%" height="100%"></iframe></div>';
    return s;
}
function tabClose() {
    /*双击关闭TAB选项卡*/
    $(".tabs-inner").dblclick(function(){
        var subtitle = $(this).children(".tabs-closable").text();
        $('#tabs').tabs('close',subtitle);
    });
}


function widgetMod(){
    var widget = $('.widget-mod');
    if (widget[0]) {
        var w_minimize = widget.find('.mod-tool .mod-tool-collapse');
        var widgetClosed = widget.find('.mod-tool .mod-tool-close');
                  
        w_minimize.on('click', function() {
            _this = $(this);
            if(_this.hasClass('mod-tool-expand')) {
                _this.closest('.mod-hd').next('.mod-bd').slideDown('200');
                _this.removeClass("mod-tool-expand");
            } else {
                _this.addClass('mod-tool-expand').closest('.mod-hd').next('.mod-bd').slideUp('200');
            }
        });

        widgetClosed.on('click', function() {
            _this = $(this);
            _this.closest('.widget-mod').hide();
        });

       // $('.work-wraper').equalHeights();
        $('.work-wraper').each(function(){
            var currentTallest = 0;
            $(this).children().each(function(i){
                if ($(this).height() > currentTallest) { currentTallest = $(this).height(); }
            });
            if ($.browser.msie && $.browser.version == 6.0) { $(this).children().css({'height': currentTallest}); }
            $(this).children().css({'min-height': currentTallest}); 
        });

    }
}


jQuery(function() {
    var homelayout = $('#home');
    var hasCloneMenu = true;
    var navlist = $("#navlist");
    var navlistItem = navlist.children('li');
    var subNavAll = navlistItem.children('ul');
    var subNavLink = navlistItem.children('a');
    var subNavLinkSubLink = subNavAll.children('li').children('a');
    //设置迷你菜单
    $('#sidebar-toggler').toggle(function(){
        homelayout.layout('setSidebar',{region:'west',value:42});
        $(this).parent().width(42);
        homelayout.addClass("isMiniLayout");
        $('#sidebar').addClass("isCollapse");
        $(this).addClass("collapse");
    
        navlistItem.find('ul').hide().removeClass('show');
        subNavLink.removeClass('expand').addClass('notExpand');
        subNavLinkSubLink.removeClass('expand').addClass('notExpand');

        if(hasCloneMenu){
            subNavAll.each(function(item, elem){
                var nbid = $(elem).prev().data('nbid');
                var nmItem = $(elem).clone(true);
                if(nbid){
                    nmItem.hide().attr({'id':'nm'+nbid});
                    nmItem.addClass('nm');
                    
                    $('body').append(nmItem);
                    hasCloneMenu = false;

                }
                //console.log('nbid= '+nbid + item);
            });

            subNavLink.hover(function(){
                var $this = $(this);
                var nbid = $this.data('nbid');
                var nmUL = $('#nm'+nbid);
                nmUL.show().trigger('mouseenter mouseleave');
                var pos = $.pony.util.getPosition($this).rightBottom();
                var nmHeight = nmUL.outerHeight();
                
                nmUL.css({left:pos.x-5+"px",top:pos.y-36+"px"});
                nmUL.find('ul').show().addClass('show');
                nmUL.hover(function(){
                   $(this).show();

                },function(){
                   $(this).hide();
                });

            },function(){
                var $this = $(this);
                var nbid = $this.data('nbid');
                var nmUL = $('#nm'+nbid);
                nmUL.hide();
            });

        }else{
            hasCloneMenu = true;
        }

    },function(){
        homelayout.layout('setSidebar',{region:'west',value:211});
        $(this).parent().width(211);
        homelayout.removeClass("isMiniLayout");
        $(this).removeClass("collapse");
        $('#date-box-bar').removeClass("collapse");
        $('#sidebar').removeClass("isCollapse");

        if(subNavLink.hasClass("notExpand")){
            //alert('aa');
            subNavLink.find('span.more i').addClass('icon-caret-down').removeClass('icon-caret-up');
        }

        if(subNavLinkSubLink.hasClass("notExpand")){
            subNavLinkSubLink.find('span.more i').addClass('icon-caret-down').removeClass('icon-caret-up');
        }

        if($('.nm')[0]){
            $('.nm').remove();
        }

        subNavLink.off('mouseenter mouseleave');

        hasCloneMenu = true;

    }).click(function(){
        homelayout.layout('setMainNav',{region:'west'});
    });

    //折叠菜单
    var navListPan = $('#nav-list-pan');
    var nav = $('#navlist');
    var navwp = $('#navlist-wraper');
    var navCurrent = nav.find('li.current');
    //var navLinkMore = nav.find('a>span.more');
    var navLinkMore = nav.find('a');
    var navSub = nav.find('li>ul.sub-nav');
    var isPan = true;
    navLinkMore.on('click',function(event){
        event.preventDefault();
        var _this = $(this);
        
        //var navTitleA = _this.closest('a');
        var navTitleA = _this;
        if(navTitleA.hasClass('notExpand')) {
            //expand ul and change class to expand
            navTitleA.next('ul').slideDown(250);
            navTitleA.next('ul').addClass('show');
            navTitleA.addClass('expand').removeClass('notExpand');
            _this.find('.more i').addClass('icon-caret-up').removeClass('icon-caret-down');
        } else if (navTitleA.hasClass('expand')) {
            //collapse ul and change class to notExpand
            navTitleA.next('ul').removeClass('show');
            navTitleA.next('ul').slideUp(250);
            navTitleA.addClass('notExpand').removeClass('expand');
            _this.find('.more i').addClass('icon-caret-down').removeClass('icon-caret-up');
        }

        var navHeight = nav.outerHeight()+72;
        var navwpHeight = navwp.height();

        //console.log(navHeight+"========>"+navwpHeight);
        if(navHeight > navwpHeight){
            //navwpHeight = $('#navlist-wraper').height();
            navListPan.show();
            //homelayout.layout('setMainNav',{region:'west'});
            /*setInterval(function(){
               navwp.slimscroll();
            }, 100);*/

            navwp.slimscroll({
                alwaysVisible: false,
                railVisible: false,
                size: '5px',
                color: '#FF692B',
                height: navwpHeight
            }).bind('slimscroll', function(e, pos) {
                navListPan.show();
                if (pos == "top") {
                    navListPan.addClass("prev").removeClass("next");
                    isPan = true;
                    //console.log("下="); 
                }else{
                    navListPan.addClass("next").removeClass("prev");
                    isPan = false;
                    //console.log("上="); 

                };
            });
            navListPan.on('click',function(){
                if (isPan){
                    navwp.slimScroll({ scrollBy: '30px'});
                    //console.log("下 "+isPan);  
                }else{
                    navwp.slimScroll({ scrollBy: '-30px'});
                    //console.log("上 "+isPan); 
                }
            });

        }else{     
            navListPan.hide();
        } 
    });


    //设置菜单滚动条
    homelayout.layout('setMainNav',{region:'west'});
    $(window).resize(function(){
        homelayout.layout('setMainNav',{region:'west'});
    });


    //功能菜单事件监听
    $('.nav-list a[data-url]').on('click', function(event) {
        event.preventDefault();
        var $this = $(this);
        var $url = $this.data('url');
        var $title = $this.find('.txt').html();
        if($url){
            addTab($title,$url);
        }else{
            $.messager.show({
                title : '提示',
                msg : '请添加超链接地址！'
            });
        }
    });

    //模拟预加载
    $("#status").fadeOut();
    $("#preloader").delay(350).fadeOut("slow");

    //系统日期
    if($('#timedate').length > 0){
        var timedate = $.pony.util.datePattern("yyyy-MM-dd EEE");
        $('#timedate').html(timedate);
    }

});
