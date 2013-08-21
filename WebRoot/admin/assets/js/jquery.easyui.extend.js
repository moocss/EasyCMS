(function($){
    /**
     * layout方法扩展
     * @param {Object} jq
     * @param {Object} region
     */
    $.extend($.fn.layout.methods, {  
        /**
         * 移除header
         * @param {Object} jq
         * @param {Object} region
         */
        removeHeader: function(jq, region){  
            return jq.each(function(){  
                var panel = $(this).layout("panel",region);
                if(panel){
                    panel.panel('removeHeader');
                    panel.panel('resize');
                }
            });  
        },
        /**
         * 增加header
         * @param {Object} jq
         * @param {Object} params
         */
        addHeader:function(jq, params){
            return jq.each(function(){  
                var panel = $(this).layout("panel",params.region);
                var opts = panel.panel("options");
                if(panel){
                    var title = params.title?params.title:opts.title;
                    panel.panel('addHeader',{title:title});
                    panel.panel('resize');
                }
            });
        },
        /**  
         * 面板是否存在和可见  
         * @param {Object} jq  
         * @param {Object} params  
         */  
        isVisible: function(jq, params) {   
            var panels = $.data(jq[0], 'layout').panels;   
            var pp = panels[params];   
            if(!pp) {   
                return false;   
            }   
            if(pp.length) {   
                return pp.panel('panel').is(':visible');   
            } else {   
                return false;   
            }   
        },   
        /**  
         * 隐藏除某个region，center除外。  
         * @param {Object} jq  
         * @param {Object} params  
         */  
        hidden: function(jq, params) {   
            return jq.each(function() {   
                var opts = $.data(this, 'layout').options;   
                var panels = $.data(this, 'layout').panels;   
                if(!opts.regionState){   
                    opts.regionState = {};   
                }   
                var region = params;   
                function hide(dom,region,doResize){   
                    var first = region.substring(0,1);   
                    var others = region.substring(1);   
                    var expand = 'expand' + first.toUpperCase() + others;   
                    if(panels[expand]) {   
                        if($(dom).layout('isVisible', expand)) {   
                            opts.regionState[region] = 1;   
                            panels[expand].panel('close');   
                        } else if($(dom).layout('isVisible', region)) { 
                            opts.regionState[region] = 0;   
                            panels[region].panel('close');   
                        }   
                    } else {   
                        panels[region].panel('close');   
                    }   
                    if(doResize){   
                        $(dom).layout('resize');   
                    }   
                };   
                if(region.toLowerCase() == 'all'){   
                    hide(this,'east',false);   
                    hide(this,'north',false);   
                    hide(this,'west',false);   
                    hide(this,'south',true);   
                }else{   
                    hide(this,region,true);   
                }   
            });   
        },   
        /**  
         * 显示某个region，center除外。  
         * @param {Object} jq  
         * @param {Object} params  
         */  
        show: function(jq, params) {   
            return jq.each(function() {   
                var opts = $.data(this, 'layout').options;   
                var panels = $.data(this, 'layout').panels;   
                var region = params;   
      
                function show(dom,region,doResize){   
                    var first = region.substring(0,1);   
                    var others = region.substring(1);   
                    var expand = 'expand' + first.toUpperCase() + others;   
                    if(panels[expand]) {   
                        if(!$(dom).layout('isVisible', expand)) {   
                            if(!$(dom).layout('isVisible', region)) {   
                                if(opts.regionState[region] == 1) {   
                                    panels[expand].panel('open');   
                                } else {   
                                    panels[region].panel('open');   
                                }   
                            }   
                        }   
                    } else {   
                        panels[region].panel('open');   
                    }   
                    if(doResize){   
                        $(dom).layout('resize');   
                    }   
                };   
                if(region.toLowerCase() == 'all'){   
                    show(this,'east',false);   
                    show(this,'north',false);   
                    show(this,'west',false);   
                    show(this,'south',true);   
                }else{   
                    show(this,region,true);   
                }   
            });   
        },
        /**
         * 设置某个region的宽度或者高度(不支持center)
         * @param {[type]} jq     [description]
         * @param {[type]} params [description]
         */
        setRegionSize:function(jq,params){
            return jq.each(function(){
                if(params.region=="center")
                    return;
                var panel = $(this).layout('panel',params.region);
                var optsOfPanel = panel.panel('options');
                if(params.region=="north" || params.region=="south"){
                    optsOfPanel.height = params.value;
                }else{
                    optsOfPanel.width = params.value;
                }
                $(this).layout('resize');
            });
        },
        setSidebar:function(jq,params){
            return jq.each(function(){
                if(params.region=="center")
                    return;
                var panel = $(this).layout('panel',params.region);
                var optsOfPanel = panel.panel('options');
                if(params.region == "west"){
                    optsOfPanel.width = params.value;
                }
                $(this).layout('resize');
            });
        },
        setMainNav:function(jq,params){
            return jq.each(function(){
                var panel = $(this).layout('panel',params.region);
                var mainnav = panel.find("#mainnav");
                var navlist = panel.find("#navlist");
                var navlistwp = panel.find("#navlist-wraper");
                var navlistH = navlist.height();
                var optsOfPanel = panel.panel('options');
                var navListPan = mainnav.find('#nav-list-pan');
                var isPan = true;                    

                //navlistwp.addClass("hasScroll");
                if(params.region == "west"){
                    //alert(optsOfPanel.height);
                    //console.log("west-width = "+ optsOfPanel.height);
                    var mnh = optsOfPanel.height-41;
                    var nlh = optsOfPanel.height-72;
                    mainnav.height(mnh);
                    navlistwp.height(nlh);
                    //console.log("---->"+nlh);
                    //判断是否有滚动条
                    if(nlh < navlistH){
                        // navlistwp.css({overflow:'hidden','overflow-y':'auto'});
                       navListPan.addClass("prev").removeClass("next");
                       navlistwp.slimscroll({
                            alwaysVisible: false,
                            railVisible: false,
                            size: '5px',
                            color: '#FF692B',
                            height: nlh
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
                                navlistwp.slimScroll({ scrollBy: '30px'});
                                //console.log("下 "+isPan);  
                            }else{
                                navlistwp.slimScroll({ scrollBy: '-30px'}); 
                                //console.log("上 "+isPan); 
                            }
                        });
                       
                        mainnav.find('.slimScrollDiv').height(nlh);
                    }else{
                        mainnav.find('.slimScrollDiv').height(nlh);
                        navListPan.hide();
                    } 

                }
                $(this).layout('resize');
            });
        },
        /**
         * 设置north south east west区域标题的图标
         * @param {[type]} jq     [description]
         * @param {[type]} params [description]
         */
        setHeaderIcon:function(jq,params){
            return jq.each(function(){
                if(params.region=="center")
                    return;
                var panel = $(this).layout('panel',params.region);
                var title = panel.panel('header').find('>div.panel-title');
                var icon = panel.panel('header').find('>div.panel-icon');
                if(icon.length===0){
                    if(title.length && params.iconCls != null){
                        $('<div class="panel-icon ' + params.iconCls + '"></div>').insertBefore(title);
                        title.addClass('panel-with-icon');
                    }
                }else{
                    if(params.iconCls == null){
                        icon.remove();
                        title.removeClass('panel-with-icon');
                    }else{
                        icon.attr('class','').addClass('panel-icon ' + params.iconCls);
                    }              
                }   
            });
        },
        /**
         * 设置north south east west的split是否可以拖动
         * @param {[type]} jq     [description]
         * @param {[type]} params [description]
         */
        setSplitActivateState:function(jq,params){
            return jq.each(function(){
                if(params.region=="center")
                    return;
                $(this).layout('panel',params.region).panel('panel').resizable(params.disabled?'disable':'enable');
            });
        },
        /**
         * 设置north south east west的split是否显示
         * @param {[type]} jq     [description]
         * @param {[type]} params [description]
         */
        setSplitVisiableState:function(jq,params){
            return jq.each(function(){
                if(params.region=="center")
                    return;
                var panel = $(this).layout('panel',params.region);
                panel.panel('options').split = params.visible;
                if(params.visible){
                    panel.panel('panel').addClass('layout-split-north');
                }else{
                    panel.panel('panel').removeClass('layout-split-north');
                }
                //panel.panel('resize');
                $(this).layout('resize');
            });
        },
        /**
         * 设置region的收缩按钮是否可见
         * @param {[type]} jq     [description]
         * @param {[type]} params [description]
         */
        setRegionToolVisableState:function(jq,params){
            return jq.each(function(){
                if(params.region=="center")
                    return;
                var panels = $.data(this, 'layout').panels;
                var panel = panels[params.region];
                var tool = panel.panel('header').find('>div.panel-tool');
                tool.css({display:params.visible?'block':'none'});
                var first = params.region.substring(0,1);   
                var others = params.region.substring(1);   
                var expand = 'expand' + first.toUpperCase() + others;  
                if(panels[expand]){
                    panels[expand].panel('header').find('>div.panel-tool').css({display:params.visible?'block':'none'});
                }
            });
        }
    });
})(jQuery);

(function($){
    function init(target,options){
        var wrap = $(target);
        if($("div.mask",wrap).length) wrap.mask("hide");
        
        wrap.attr("position",wrap.css("position"));
        wrap.attr("overflow",wrap.css("overflow"));
        wrap.css("position", "relative");
        wrap.css("overflow", "hidden");
        
        var maskCss = {
            position:"absolute",
            left:0,
            top:0,
            cursor: "wait",
            background:"#ccc",
            opacity:options.opacity,
            filter:"alpha(opacity="+options.opacity*100+")",
            display:"none"
        };
        
        var maskMsgCss = {
            position:"absolute",
            width:"auto",
            padding:"10px 20px",
            border:"2px solid #ccc",
            color:"white",
            cursor: "wait",
            display:"none",
            borderRadius:5,
            background:"black",
            opacity:0.6,
            filter:"alpha(opacity=60)"
        };
        var width,height,left,top;
        if(target == 'body'){
            width = Math.max(document.documentElement.clientWidth, document.body.clientWidth);
            height = Math.max(document.documentElement.clientHeight, document.body.clientHeight);
        }else{
            width = wrap.outerWidth() || "100%";
            height = wrap.outerHeight() || "100%";
        }
        $('<div class="mask"></div>').css($.extend({},maskCss,{
            display : 'block',
            width : width,
            height : height,
            zIndex:options.zIndex
        })).appendTo(wrap);

        var maskm= $('<div class="mask-msg"></div>').html(options.maskMsg).appendTo(wrap).css(maskMsgCss);
        
        if(target == 'body'){
            left = (Math.max(document.documentElement.clientWidth,document.body.clientWidth) - $('div.mask-msg', wrap).outerWidth())/ 2;
            if(document.documentElement.clientHeight > document.body.clientHeight){
                top = (Math.max(document.documentElement.clientHeight,document.body.clientHeight)  - $('div.mask-msg', wrap).outerHeight())/ 2;
            }else{
                top = (Math.min(document.documentElement.clientHeight,document.body.clientHeight)  - $('div.mask-msg', wrap).outerHeight())/ 2;
            }
            
        }else{
            left = (wrap.width() - $('div.mask-msg', wrap).outerWidth())/ 2;
            top = (wrap.height() - $('div.mask-msg', wrap).outerHeight())/ 2;
        }
        
        maskm.css({
            display : 'block',
            zIndex:options.zIndex+1,
            left : left,
            top :  top
        });
        
        setTimeout(function(){
            wrap.mask("hide");
        }, options.timeout);
            
        return wrap;
    }
       
    $.fn.mask = function(options){   
        if (typeof options == 'string'){
            return $.fn.mask.methods[options](this);
        }
        options = $.extend({}, $.fn.mask.defaults,options);
        return init(this,options);
    };
    $.mask = function(options){  
        if (typeof options == 'string'){
            return $.fn.mask.methods[options]("body");
        }
        options = $.extend({}, $.fn.mask.defaults,options);
        return init("body",options);
    };
    
    $.mask.hide = function(){
        $("body").mask("hide");
    };
    
    $.fn.mask.methods = {
        hide : function(jq) {
            return jq.each(function() {
                var wrap = $(this);
                $("div.mask",wrap).fadeOut(function(){
                    $(this).remove();
                });
                $("div.mask-msg",wrap).fadeOut(function(){
                    $(this).remove();
                    wrap.css("position",  wrap.attr("position"));
                    wrap.css("overflow", wrap.attr("overflow"));
                });
            });
        }
    };
    
    $.fn.mask.defaults = {
        maskMsg:'\u52a0\u8f7d……',
        zIndex:100000,
        timeout:30000,
        opacity:0.6
    };
})(jQuery);

(function ($) {
    function S4() {
        return (((1 + Math.random()) * 0x10000) | 0).toString(16).substring(1);
    }
    function CreateIndentityWindowId() {
        return "UUID-" + (S4() + S4() + "-" + S4() + "-" + S4() + "-" + S4() + "-" + S4() + S4() + S4());
    }
    function destroy(target) {
        $(target).dialog("destroy");
    }
    function getWindow(target) {
        if (typeof target == "string") {
            return document.getElementById(target);
        } else {
            return $(target).closest(".window-body");
        }
    }
    $.createWin = function (options) {
        if (!options.url && !options.contents) {
            $.messager.alert("提示", "缺少必要参数!(url or contents)");
            return false;
        }
        var windowId = CreateIndentityWindowId();
        if (options.winId) {
            windowId = options.winId;
        } else {
            options.winId = windowId;
        }
        var defaultBtn = [{
                text : '关闭',
                handler : function () {
                    $("#" + windowId).dialog("close");
                }
            }
        ];
        $.merge(options.buttons || [], defaultBtn);
        options = $.extend({}, $.createWin.defaults, options || {});
        if (options.isMax) {
            options.draggable = false;
            options.closed = true;
        }
        var dialog = $('<div/>');
        if (options.target != 'body') {
            options.inline = true;
        }
        dialog.appendTo($(options.target));
        dialog.dialog($.extend({}, options, {
                onClose : function () {
                    if (typeof options.onClose == "function") {
                        options.onClose.call(dialog,$);
                    }
                    destroy(this);
                },
                onMove : function (left, top) {
                    if (typeof options.onMove == "function") {
                        options.onMove.call(dialog,$);
                    }
                    var o = $.data(this, 'panel').options;
                    if (top < 0) {
                        $(this).dialog("move", {
                            "left" : left,
                            "top" : 0
                        });
                    } else if (o.maximized) {
                        $(this).dialog("restore");
                        $(this).dialog("move", {
                            "left" : left + 100,
                            "top" : top
                        });
                    }
                    if (top > ($(o.target).height() - 20)) {
                        $(this).dialog("move", {
                            "left" : left,
                            "top" : ($(o.target).height() - 25)
                        });
                    }
                }
            }));
        if (options.align) {
            var w = dialog.closest(".window");
            switch (options.align) {
            case "right":
                dialog.dialog("move", {
                    left : w.parent().width() - w.width() - 10
                });
                break;
            case "tright":
                dialog.dialog("move", {
                    left : w.parent().width() - w.width() - 10,
                    top : 0
                });
                break;
            case "bright":
                dialog.dialog("move", {
                    left : w.parent().width() - w.width() - 10,
                    top : w.parent().height() - w.height() - 10
                });
                break;
            case "left":
                dialog.dialog("move", {
                    left : 0
                });
                break;
            case "tleft":
                dialog.dialog("move", {
                    left : 0,
                    top : 0
                });
                break;
            case "bleft":
                dialog.dialog("move", {
                    left : 0,
                    top : w.parent().height() - w.height() - 10
                });
                break;
            case "top":
                dialog.dialog("move", {
                    top : 0
                });
                break;
            case "bottom":
                //alert('w.height() - 10='+(w.height() - 10)+' \nw.parent().parent.height()='+(w.parent().parent().height() ) +'\nw.parent().height() - w.height() - 10='+(w.parent().height() - w.height() - 10));
                dialog.dialog("move", {
                    top : w.parent().height() - w.height() - 10
                });
                break;
            }
        }
        if (options.isMax) {
            dialog.dialog("maximize");
            dialog.dialog("open");
        }
        if ($.fn.mask && options.mask)
            　dialog.mask();
        if (options.contents) {
            ajaxSuccess(options.contents);
        } else {
            if (!options.isIframe) {
                $.ajax({
                    url : options.url,
                    type : options.ajaxType || "POST",
                    data : options.data == null ? "" : options.data,
                    success : function (date) {
                        ajaxSuccess(date);
                    },
                    error : function () {
                        $.messager.alert("提示", "加载失败！");
                        if ($.fn.mask && options.mask)
                            dialog.mask("hide");
                    }
                });
            } else {
                ajaxSuccess();
            }
        }
        dialog.attr("id",windowId);
        return dialog;
        function ajaxSuccess(date) {
            if (options.isIframe && !date) {
                dialog.find("div.dialog-content").html('<iframe width="100%" height="100%" frameborder="0" src="' + options.url + '" ></iframe>');
            } else {
                dialog.find("div.dialog-content").html(date);
            }
            $.parser.parse(dialog);
            options.onComplete.call(this, dialog,$);
            if ($.fn.mask && options.mask)
                dialog.mask("hide");
        }
    };
    $.fn.destroy = function () {
        destroy(this);
    };
    window.GETWIN = getWindow;
    $.createWin.defaults = $.extend({}, $.fn.dialog.defaults, {
            url : '',
            data : '',
            ajaxType:"POST",
            target : 'body',
            height : 200,
            width : 400,
            collapsible : false,
            minimizable : false,
            maximizable : false,
            closable : true,
            modal : true,
            shadow : false,
            mask : true,
            onComplete : function (dialog,jq) {}
    });
})(jQuery);

(function ($) {
    /**
     * @requires jQuery,EasyUI
     * panel关闭时回收内存，主要用于layout使用iframe嵌入网页时的内存泄漏问题
     */
    $.fn.panel.defaults.onBeforeDestroy = function() {
        var frame = $('iframe', this);
        try {
            if (frame.length > 0) {
                for ( var i = 0; i < frame.length; i++) {
                    frame[i].contentWindow.document.write('');
                    frame[i].contentWindow.close();
                }
                frame.remove();
                if ($.browser.msie) {
                    CollectGarbage();
                }
            }
        } catch (e) {
        }
    };

    /**
     * 使panel和datagrid在加载时提示
     * @requires jQuery,EasyUI
     */
    $.fn.panel.defaults.loadingMessage = '加载中....';

    /**
     * @requires jQuery,EasyUI
     * 防止panel/window/dialog组件超出浏览器边界
     * @param left
     * @param top
     */
    var easyuiPanelOnMove = function(left, top) {
        var l = left;
        var t = top;
        if (l < 1) {
            l = 1;
        }
        if (t < 1) {
            t = 1;
        }
        var width = parseInt($(this).parent().css('width')) + 14;
        var height = parseInt($(this).parent().css('height')) + 14;
        var right = l + width;
        var buttom = t + height;
        var browserWidth = $(window).width();
        var browserHeight = $(window).height();
        if (right > browserWidth) {
            l = browserWidth - width;
        }
        if (buttom > browserHeight) {
            t = browserHeight - height;
        }
        $(this).parent().css({/* 修正面板位置 */
            left : l,
            top : t
        });
    };
    $.fn.dialog.defaults.onMove = easyuiPanelOnMove;
    $.fn.window.defaults.onMove = easyuiPanelOnMove;
    $.fn.panel.defaults.onMove = easyuiPanelOnMove;

    if ($.messager){
        $.messager.defaults.ok = '确定';
        $.messager.defaults.cancel = '取消';
    }
    if ($.fn.calendar){
        $.fn.calendar.defaults.weeks = ['日','一','二','三','四','五','六'];
        $.fn.calendar.defaults.months = ['一月','二月','三月','四月','五月','六月','七月','八月','九月','十月','十一月','十二月'];
    }
    if ($.fn.datebox){
        $.fn.datebox.defaults.currentText = '今天';
        $.fn.datebox.defaults.closeText = '关闭';
        $.fn.datebox.defaults.okText = '确定';
        $.fn.datebox.defaults.missingMessage = '该输入项为必输项';
        $.fn.datebox.defaults.formatter = function(date){
            var y = date.getFullYear();
            var m = date.getMonth()+1;
            var d = date.getDate();
            return y+'-'+(m<10?('0'+m):m)+'-'+(d<10?('0'+d):d);
        };
        $.fn.datebox.defaults.parser = function(s){
            if (!s) return new Date();
            var ss = s.split('-');
            var y = parseInt(ss[0],10);
            var m = parseInt(ss[1],10);
            var d = parseInt(ss[2],10);
            if (!isNaN(y) && !isNaN(m) && !isNaN(d)){
                return new Date(y,m-1,d);
            } else {
                return new Date();
            }
        };
    }
    if ($.fn.datetimebox && $.fn.datebox){
        $.extend($.fn.datetimebox.defaults,{
            currentText: $.fn.datebox.defaults.currentText,
            closeText: $.fn.datebox.defaults.closeText,
            okText: $.fn.datebox.defaults.okText,
            missingMessage: $.fn.datebox.defaults.missingMessage
        });
    }

})(jQuery);

(function($) {
    /**
     * dialog的封装操作
     */
    $.dialog = function(options) {
        var _default = {
            minimizable: false,
            modal: true,
            collapsible: false,
            maximizable: false,
            onClose: function() {
                $(this).dialog('destroy');
            }
        };

        options = $.extend(_default, options);

        var dialog = $(options.el || "<div/>");
        if (options.bodyStyle) {
            dialog.css(options.bodyStyle);
        }

        $.get(options.href, function(rsp) {
            options.href = null;
            dialog.dialog(options);
            var content = dialog.find('div.dialog-content');
            content.html($.fn.panel.defaults.extractor(rsp));
            if ($.parser) {
                $.parser.parse(content);
            }
            if (options.onLoad) {
                options.onLoad.call(dialog);
            }
        }, "html");

        dialog.close = function() {
            dialog.dialog('destroy');
        };
        return dialog;
    };

    $.alert = function() {
        if (arguments.length === 1) {
            $.messager.alert("提示", arguments[0]);
        } else if (arguments.length === 2 && typeof arguments[1] === "string") {
            $.messager.alert("提示", arguments[0], arguments[1]);
        } else if (arguments.length === 2 && typeof arguments[1] === "function") {
            $.messager.alert("提示", arguments[0], "", arguments[1]);
        } else if (arguments.length === 3) {
            $.messager.alert("提示", arguments[0], arguments[1], arguments[2]);
        }
    };
    $.confirm = function(msg, callback) {
        $.messager.confirm("确认", msg, callback);
    };

    /**
     * My97插件
     */
    $.fn.my97 = function(options, params) {
        if (typeof options == "string") {
            return $.fn.my97.methods[options](this, params);
        }
        options = options || {};
        if (!WdatePicker) {
            alert("未引入My97js包！");
            return;
        }
        return this.each(function() {
            var data = $.data(this, "my97");
            var newOptions;
            if (data) {
                newOptions = $.extend(data.options, options);
                data.opts = newOptions;
            } else {
                newOptions = $.extend({}, $.fn.my97.defaults, $.fn.my97.parseOptions(this), options);
                $.data(this, "my97", {
                    options: newOptions
                });
            }
            $(this).addClass('Wdate').click(function() {
                WdatePicker(newOptions);
            });
        });
    };
    $.fn.my97.methods = {
        setValue: function(target, params) {
            target.val(params);
        },
        getValue: function(target) {
            return target.val();
        },
        clearValue: function(target) {
            target.val('');
        }
    };
    $.fn.my97.parseOptions = function(target) {
        return $.extend({}, $.parser.parseOptions(target, ["el", "vel", "weekMethod", "lang", "skin", "dateFmt", "realDateFmt", "realTimeFmt", "realFullFmt", "minDate", "maxDate", "startDate", {
                doubleCalendar: "boolean",
                enableKeyboard: "boolean",
                enableInputMask: "boolean",
                autoUpdateOnChanged: "boolean",
                firstDayOfWeek: "number",
                isShowWeek: "boolean",
                highLineWeekDay: "boolean",
                isShowClear: "boolean",
                isShowToday: "boolean",
                isShowOthers: "boolean",
                readOnly: "boolean",
                errDealMode: "boolean",
                autoPickDate: "boolean",
                qsEnabled: "boolean",
                autoShowQS: "boolean",
                opposite: "boolean"
            }
        ]));
    };
    $.fn.my97.defaults = {
        dateFmt: 'yyyy-MM-dd'
        //dateFmt: 'yyyy-MM-dd HH:mm:ss'
    };

    $.parser.plugins.push('my97');

    /* 使用方法 */
    /*
    可以通过class实例化
    <input  class="easyui-my97" type="text">

    通过代码实例化
    <input  id="my97" type="text" name="">
    $('#my97').my97(options);
    */
})(jQuery);

