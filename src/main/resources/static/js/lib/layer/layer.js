!function(h,d){var e,g,i={getPath:function(){var m=document.scripts,k=m[m.length-1],l="/static/js/lib/layer/";if(k.getAttribute("merge")){return}return l.substring(0,l.lastIndexOf("/")+1)}(),enter:function(k){if(k.keyCode===13){k.preventDefault()}},config:{},end:{},btn:["&#x786E;&#x5B9A;","&#x53D6;&#x6D88;"],type:["dialog","page","iframe","loading","tips"]};var f={v:"2.4",ie6:!!h.ActiveXObject&&!h.XMLHttpRequest,index:0,path:i.getPath,config:function(l,m){var n=0;l=l||{};f.cache=i.config=e.extend(i.config,l);f.path=i.config.path||f.path;typeof l.extend==="string"&&(l.extend=[l.extend]);f.use("skin/layer.css",(l.extend&&l.extend.length>0)?(function k(){var o=l.extend;f.use(o[o[n]?n:n-1],n<o.length?function(){++n;return k}():m)}()):m);return this},use:function(l,r,n){var p=0,s=e("head")[0];var l=l.replace(/\s/g,"");var o=/\.css$/.test(l);var m=document.createElement(o?"link":"script");var k="layui_layer_"+l.replace(/\.|\//g,"");if(!f.path){return}if(o){m.rel="stylesheet"}m[o?"href":"src"]=/^http:\/\//.test(l)?l:f.path+l;m.id=k;if(!e("#"+k)[0]){s.appendChild(m)}(function q(){(o?parseInt(e("#"+k).css("width"))===1989:f[n||k])?function(){r&&r();try{o||s.removeChild(m)}catch(t){}}():setTimeout(q,100)}());return this},ready:function(m,l){var k=typeof m==="function";if(k){l=m}f.config(e.extend(i.config,function(){return k?{}:{path:m}}()),l);return this},alert:function(m,k,n){var l=typeof k==="function";if(l){n=k}return f.open(e.extend({content:m,yes:n},l?{}:k))},confirm:function(n,k,o,m){var l=typeof k==="function";if(l){m=o;o=k}return f.open(e.extend({content:n,btn:i.btn,yes:o,btn2:m},l?{}:k))},msg:function(o,m,l){var n=typeof m==="function",q=i.config.skin;var p=(q?q+" "+q+"-msg":"")||"layui-layer-msg";var k=c.anim.length-1;if(n){l=m}return f.open(e.extend({content:o,time:3000,shade:false,skin:p,title:false,closeBtn:false,btn:false,end:l},(n&&!i.config.skin)?{skin:p+" layui-layer-hui",shift:k}:function(){m=m||{};if(m.icon===-1||m.icon===d&&!i.config.skin){m.skin=p+" "+(m.skin||"layui-layer-hui")}return m}()))},load:function(l,k){return f.open(e.extend({type:3,icon:l||0,shade:0.01},k))},tips:function(m,k,l){return f.open(e.extend({type:4,content:[m,k],closeBtn:false,time:3000,shade:false,fix:false,maxWidth:210},l))}};var b=function(k){var l=this;l.index=++f.index;l.config=e.extend({},l.config,i.config,k);l.creat()};b.pt=b.prototype;var c=["layui-layer",".layui-layer-title",".layui-layer-main",".layui-layer-dialog","layui-layer-iframe","layui-layer-content","layui-layer-btn","layui-layer-close"];c.anim=["layer-anim","layer-anim-01","layer-anim-02","layer-anim-03","layer-anim-04","layer-anim-05","layer-anim-06"];b.pt.config={type:0,shade:0.3,fix:true,move:c[1],title:"&#x4FE1;&#x606F;",offset:"auto",area:"auto",closeBtn:1,time:0,zIndex:19891014,maxWidth:360,shift:0,icon:-1,scrollbar:true,tips:2};b.pt.vessel=function(o,s){var p=this,k=p.index,n=p.config;var r=n.zIndex+k,m=typeof n.title==="object";var q=n.maxmin&&(n.type===1||n.type===2);var l=(n.title?'<div class="layui-layer-title" style="'+(m?n.title[1]:"")+'">'+(m?n.title[0]:n.title)+"</div>":"");n.zIndex=r;s([n.shade?('<div class="layui-layer-shade" id="layui-layer-shade'+k+'" times="'+k+'" style="'+("z-index:"+(r-1)+"; background-color:"+(n.shade[1]||"#000")+"; opacity:"+(n.shade[0]||n.shade)+"; filter:alpha(opacity="+(n.shade[0]*100||n.shade*100)+");")+'"></div>'):"",'<div class="'+c[0]+(" layui-layer-"+i.type[n.type])+(((n.type==0||n.type==2)&&!n.shade)?" layui-layer-border":"")+" "+(n.skin||"")+'" id="'+c[0]+k+'" type="'+i.type[n.type]+'" times="'+k+'" showtime="'+n.time+'" conType="'+(o?"object":"string")+'" style="z-index: '+r+"; width:"+n.area[0]+";height:"+n.area[1]+(n.fix?"":";position:absolute;")+'">'+(o&&n.type!=2?"":l)+'<div id="'+(n.id||"")+'" class="layui-layer-content'+((n.type==0&&n.icon!==-1)?" layui-layer-padding":"")+(n.type==3?" layui-layer-loading"+n.icon:"")+'">'+(n.type==0&&n.icon!==-1?'<i class="layui-layer-ico layui-layer-ico'+n.icon+'"></i>':"")+(n.type==1&&o?"":(n.content||""))+"</div>"+'<span class="layui-layer-setwin">'+function(){var t=q?'<a class="layui-layer-min" href="javascript:;"><cite></cite></a><a class="layui-layer-ico layui-layer-max" href="javascript:;"></a>':"";n.closeBtn&&(t+='<a class="layui-layer-ico '+c[7]+" "+c[7]+(n.title?n.closeBtn:(n.type==4?"1":"2"))+'" href="javascript:;"></a>');return t}()+"</span>"+(n.btn?function(){var v="";typeof n.btn==="string"&&(n.btn=[n.btn]);for(var u=0,t=n.btn.length;u<t;u++){v+='<a class="'+c[6]+""+u+'">'+n.btn[u]+"</a>"}return'<div class="'+c[6]+'">'+v+"</div>"}():"")+"</div>"],l);return p};b.pt.creat=function(){var m=this,k=m.config,o=m.index,p;var l=k.content,n=typeof l==="object";if(e("#"+k.id)[0]){return}if(typeof k.area==="string"){k.area=k.area==="auto"?["",""]:[k.area,""]}switch(k.type){case 0:k.btn=("btn" in k)?k.btn:i.btn[0];f.closeAll("dialog");break;case 2:var l=k.content=n?k.content:[k.content||"http://layer.layui.com","auto"];
    k.content='<iframe scrolling="'+(k.content[1]||"auto")+'" allowtransparency="true" id="'+c[4]+""+o+'" name="'+c[4]+""+o+'" onload="this.className=\'\';" class="layui-layer-load" frameborder="0" src="'+k.content[0]+'"></iframe>';break;case 3:k.title=false;k.closeBtn=false;k.icon===-1&&(k.icon===0);f.closeAll("loading");break;case 4:n||(k.content=[k.content,"body"]);k.follow=k.content[1];k.content=k.content[0]+'<i class="layui-layer-TipsG"></i>';k.title=false;k.tips=typeof k.tips==="object"?k.tips:[k.tips,true];k.tipsMore||f.closeAll("tips");break}m.vessel(n,function(r,q){e("body").append(r[0]);n?function(){(k.type==2||k.type==4)?function(){e("body").append(r[1])}():function(){if(!l.parents("."+c[0])[0]){l.show().addClass("layui-layer-wrap").wrap(r[1]);e("#"+c[0]+o).find("."+c[5]).before(q)}}()}():e("body").append(r[1]);m.layero=e("#"+c[0]+o);k.scrollbar||c.html.css("overflow","hidden").attr("layer-full",o)}).auto(o);k.type==2&&f.ie6&&m.layero.find("iframe").attr("src",l[0]);e(document).off("keydown",i.enter).on("keydown",i.enter);m.layero.on("keydown",function(q){e(document).off("keydown",i.enter)});k.type==4?m.tips():m.offset();if(k.fix){g.on("resize",function(){m.offset();(/^\d+%$/.test(k.area[0])||/^\d+%$/.test(k.area[1]))&&m.auto(o);k.type==4&&m.tips()})}k.time<=0||setTimeout(function(){f.close(m.index)},k.time);m.move().callback();if(c.anim[k.shift]){m.layero.addClass(c.anim[k.shift])}};b.pt.auto=function(o){var q=this,n=q.config,m=e("#"+c[0]+o);if(n.area[0]===""&&n.maxWidth>0){if(/MSIE 7/.test(navigator.userAgent)&&n.btn){m.width(m.innerWidth())}m.outerWidth()>n.maxWidth&&m.width(n.maxWidth)}var p=[m.innerWidth(),m.innerHeight()];var r=m.find(c[1]).outerHeight()||0;var l=m.find("."+c[6]).outerHeight()||0;function k(s){s=m.find(s);s.height(p[1]-r-l-2*(parseFloat(s.css("padding"))|0))}switch(n.type){case 2:k("iframe");break;default:if(n.area[1]===""){if(n.fix&&p[1]>=g.height()){p[1]=g.height();k("."+c[5])}}else{k("."+c[5])}break}return q};b.pt.offset=function(){var o=this,l=o.config,k=o.layero;var n=[k.outerWidth(),k.outerHeight()];var m=typeof l.offset==="object";o.offsetTop=(g.height()-n[1])/2;o.offsetLeft=(g.width()-n[0])/2;if(m){o.offsetTop=l.offset[0];o.offsetLeft=l.offset[1]||o.offsetLeft}else{if(l.offset!=="auto"){o.offsetTop=l.offset;if(l.offset==="rb"){o.offsetTop=g.height()-n[1];o.offsetLeft=g.width()-n[0]}}}if(!l.fix){o.offsetTop=/%$/.test(o.offsetTop)?g.height()*parseFloat(o.offsetTop)/100:parseFloat(o.offsetTop);o.offsetLeft=/%$/.test(o.offsetLeft)?g.width()*parseFloat(o.offsetLeft)/100:parseFloat(o.offsetLeft);o.offsetTop+=g.scrollTop();o.offsetLeft+=g.scrollLeft()}k.css({top:o.offsetTop,left:o.offsetLeft})};b.pt.tips=function(){var r=this,q=r.config,m=r.layero;var p=[m.outerWidth(),m.outerHeight()],l=e(q.follow);if(!l[0]){l=e("body")}var o={width:l.outerWidth(),height:l.outerHeight(),top:l.offset().top,left:l.offset().left},n=m.find(".layui-layer-TipsG");var k=q.tips[0];q.tips[1]||n.remove();o.autoLeft=function(){if(o.left+p[0]-g.width()>0){o.tipLeft=o.left+o.width-p[0];n.css({right:12,left:"auto"})}else{o.tipLeft=o.left}};o.where=[function(){o.autoLeft();o.tipTop=o.top-p[1]-10;n.removeClass("layui-layer-TipsB").addClass("layui-layer-TipsT").css("border-right-color",q.tips[1])},function(){o.tipLeft=o.left+o.width+10;o.tipTop=o.top;n.removeClass("layui-layer-TipsL").addClass("layui-layer-TipsR").css("border-bottom-color",q.tips[1])},function(){o.autoLeft();o.tipTop=o.top+o.height+10;n.removeClass("layui-layer-TipsT").addClass("layui-layer-TipsB").css("border-right-color",q.tips[1])},function(){o.tipLeft=o.left-p[0]-10;o.tipTop=o.top;n.removeClass("layui-layer-TipsR").addClass("layui-layer-TipsL").css("border-bottom-color",q.tips[1])}];o.where[k-1]();if(k===1){o.top-(g.scrollTop()+p[1]+8*2)<0&&o.where[2]()}else{if(k===2){g.width()-(o.left+o.width+p[0]+8*2)>0||o.where[3]()}else{if(k===3){(o.top-g.scrollTop()+o.height+p[1]+8*2)-g.height()>0&&o.where[0]()}else{if(k===4){p[0]+8*2-o.left>0&&o.where[1]()}}}}m.find("."+c[5]).css({"background-color":q.tips[1],"padding-right":(q.closeBtn?"30px":"")});m.css({left:o.tipLeft-(q.fix?g.scrollLeft():0),top:o.tipTop-(q.fix?g.scrollTop():0)})};b.pt.move=function(){var m=this,l=m.config,k={setY:0,moveLayer:function(){var o=k.layero,p=parseInt(o.css("margin-left"));var q=parseInt(k.move.css("left"));p===0||(q=q-p);if(o.css("position")!=="fixed"){q=q-o.parent().offset().left;k.setY=0}o.css({left:q,top:parseInt(k.move.css("top"))-k.setY})}};var n=m.layero.find(l.move);l.move&&n.attr("move","ok");n.css({cursor:l.move?"move":"auto"});e(l.move).on("mousedown",function(s){s.preventDefault();if(e(this).attr("move")==="ok"){k.ismove=true;k.layero=e(this).parents("."+c[0]);var q=k.layero.offset().left,r=k.layero.offset().top,p=k.layero.outerWidth()-6,o=k.layero.outerHeight()-6;if(!e("#layui-layer-moves")[0]){e("body").append('<div id="layui-layer-moves" class="layui-layer-moves" style="left:'+q+"px; top:"+r+"px; width:"+p+"px; height:"+o+'px; z-index:2147483584"></div>')
}k.move=e("#layui-layer-moves");l.moveType&&k.move.css({visibility:"hidden"});k.moveX=s.pageX-k.move.position().left;k.moveY=s.pageY-k.move.position().top;k.layero.css("position")!=="fixed"||(k.setY=g.scrollTop())}});e(document).mousemove(function(s){if(k.ismove){var p=s.pageX-k.moveX,r=s.pageY-k.moveY;s.preventDefault();if(!l.moveOut){k.setY=g.scrollTop();var o=g.width()-k.move.outerWidth(),q=k.setY;p<0&&(p=0);p>o&&(p=o);r<q&&(r=q);r>g.height()-k.move.outerHeight()+k.setY&&(r=g.height()-k.move.outerHeight()+k.setY)}k.move.css({left:p,top:r});l.moveType&&k.moveLayer();p=r=o=q=null}}).mouseup(function(){try{if(k.ismove){k.moveLayer();k.move.remove();l.moveEnd&&l.moveEnd()}k.ismove=false}catch(o){k.ismove=false}});return m};b.pt.callback=function(){var n=this,k=n.layero,l=n.config;n.openLayer();if(l.success){if(l.type==2){k.find("iframe").on("load",function(){l.success(k,n.index)})}else{l.success(k,n.index)}}f.ie6&&n.IE6(k);k.find("."+c[6]).children("a").on("click",function(){var o=e(this).index();if(o===0){if(l.yes){l.yes(n.index,k)}else{if(l["btn1"]){l["btn1"](n.index,k)}else{f.close(n.index)}}}else{var p=l["btn"+(o+1)]&&l["btn"+(o+1)](n.index,k);p===false||f.close(n.index)}});function m(){var o=l.cancel&&l.cancel(n.index,k);o===false||f.close(n.index)}k.find("."+c[7]).on("click",m);if(l.shadeClose){e("#layui-layer-shade"+n.index).on("click",function(){f.close(n.index)})}k.find(".layui-layer-min").on("click",function(){var o=l.min&&l.min(k);o===false||f.min(n.index,l)});k.find(".layui-layer-max").on("click",function(){if(e(this).hasClass("layui-layer-maxmin")){f.restore(n.index);l.restore&&l.restore(k)}else{f.full(n.index,l);setTimeout(function(){l.full&&l.full(k)},100)}});l.end&&(i.end[n.index]=l.end)};i.reselect=function(){e.each(e("select"),function(k,l){var m=e(this);if(!m.parents("."+c[0])[0]){(m.attr("layer")==1&&e("."+c[0]).length<1)&&m.removeAttr("layer").show()}m=null})};b.pt.IE6=function(k){var l=this,n=k.offset().top;function m(){k.css({top:n+(l.config.fix?g.scrollTop():0)})}m();g.scroll(m);e("select").each(function(o,p){var q=e(this);if(!q.parents("."+c[0])[0]){q.css("display")==="none"||q.attr({"layer":"1"}).hide()}q=null})};b.pt.openLayer=function(){var k=this;f.zIndex=k.config.zIndex;f.setTop=function(l){var m=function(){f.zIndex++;l.css("z-index",f.zIndex+1)};f.zIndex=parseInt(l[0].style.zIndex);l.on("mousedown",m);return f.zIndex}};i.record=function(k){var l=[k.width(),k.height(),k.position().top,k.position().left+parseFloat(k.css("margin-left"))];k.find(".layui-layer-max").addClass("layui-layer-maxmin");k.attr({area:l})};i.rescollbar=function(k){if(c.html.attr("layer-full")==k){if(c.html[0].style.removeProperty){c.html[0].style.removeProperty("overflow")}else{c.html[0].style.removeAttribute("overflow")}c.html.removeAttr("layer-full")}};h.layer=f;f.getChildFrame=function(k,l){l=l||e("."+c[4]).attr("times");return e("#"+c[0]+l).find("iframe").contents().find(k)};f.getFrameIndex=function(k){return e("#"+k).parents("."+c[4]).attr("times")};f.iframeAuto=function(n){if(!n){return}var m=f.getChildFrame("html",n).outerHeight();var l=e("#"+c[0]+n);var o=l.find(c[1]).outerHeight()||0;var k=l.find("."+c[6]).outerHeight()||0;l.css({height:m+o+k});l.find("iframe").css({height:m})};f.iframeSrc=function(l,k){e("#"+c[0]+l).find("iframe").attr("src",k)};f.style=function(n,m){var l=e("#"+c[0]+n),o=l.attr("type");var p=l.find(c[1]).outerHeight()||0;var k=l.find("."+c[6]).outerHeight()||0;if(o===i.type[1]||o===i.type[2]){l.css(m);if(o===i.type[2]){l.find("iframe").css({height:parseFloat(m.height)-p-k})}}};f.min=function(m,l){var k=e("#"+c[0]+m);var n=k.find(c[1]).outerHeight()||0;i.record(k);f.style(m,{width:180,height:n,overflow:"hidden"});k.find(".layui-layer-min").hide();k.attr("type")==="page"&&k.find(c[4]).hide();i.rescollbar(m)};f.restore=function(l){var k=e("#"+c[0]+l),n=k.attr("area").split(",");var m=k.attr("type");f.style(l,{width:parseFloat(n[0]),height:parseFloat(n[1]),top:parseFloat(n[2]),left:parseFloat(n[3]),overflow:"visible"});k.find(".layui-layer-max").removeClass("layui-layer-maxmin");k.find(".layui-layer-min").show();k.attr("type")==="page"&&k.find(c[4]).show();i.rescollbar(l)};f.full=function(l){var k=e("#"+c[0]+l),m;i.record(k);if(!c.html.attr("layer-full")){c.html.css("overflow","hidden").attr("layer-full",l)}clearTimeout(m);m=setTimeout(function(){var n=k.css("position")==="fixed";f.style(l,{top:n?0:g.scrollTop(),left:n?0:g.scrollLeft(),width:g.width(),height:g.height()});k.find(".layui-layer-min").hide()},100)};f.title=function(l,k){var m=e("#"+c[0]+(k||f.index)).find(c[1]);m.html(l)};f.close=function(l){var k=e("#"+c[0]+l),o=k.attr("type");if(!k[0]){return}if(o===i.type[1]&&k.attr("conType")==="object"){k.children(":not(."+c[5]+")").remove();for(var m=0;m<2;m++){k.find(".layui-layer-wrap").unwrap().hide()}}else{if(o===i.type[2]){try{var n=e("#"+c[4]+l)[0];n.contentWindow.document.write("");n.contentWindow.close();k.find("."+c[5])[0].removeChild(n)}catch(p){}}k[0].innerHTML="";k.remove()
}e("#layui-layer-moves, #layui-layer-shade"+l).remove();f.ie6&&i.reselect();i.rescollbar(l);e(document).off("keydown",i.enter);try{typeof i.end[l]==="function"&&i.end[l]();delete i.end[l]}catch(p){}};f.closeAll=function(k){e.each(e("."+c[0]),function(){var m=e(this);var l=k?(m.attr("type")===k):1;l&&f.close(m.attr("times"));l=null})};var a=f.cache||{},j=function(k){return(a.skin?(" "+a.skin+" "+a.skin+"-"+k):"")};f.prompt=function(l,n){l=l||{};if(typeof l==="function"){n=l}var k,m=l.formType==2?'<textarea class="layui-layer-input">'+(l.value||"")+"</textarea>":function(){return'<input type="'+(l.formType==1?"password":"text")+'" class="layui-layer-input" value="'+(l.value||"")+'">'}();return f.open(e.extend({btn:["&#x786E;&#x5B9A;","&#x53D6;&#x6D88;"],content:m,skin:"layui-layer-prompt"+j("prompt"),success:function(o){k=o.find(".layui-layer-input");k.focus()},yes:function(o){var p=k.val();if(p===""){k.focus()}else{if(p.length>(l.maxlength||500)){f.tips("&#x6700;&#x591A;&#x8F93;&#x5165;"+(l.maxlength||500)+"&#x4E2A;&#x5B57;&#x6570;",k,{tips:1})}else{n&&n(p,o,k)}}}},l))};f.tab=function(k){k=k||{};var l=k.tab||{};return f.open(e.extend({type:1,skin:"layui-layer-tab"+j("tab"),title:function(){var m=l.length,n=1,o="";if(m>0){o='<span class="layui-layer-tabnow">'+l[0].title+"</span>";for(;n<m;n++){o+="<span>"+l[n].title+"</span>"}}return o}(),content:'<ul class="layui-layer-tabmain">'+function(){var m=l.length,n=1,o="";if(m>0){o='<li class="layui-layer-tabli xubox_tab_layer">'+(l[0].content||"no content")+"</li>";for(;n<m;n++){o+='<li class="layui-layer-tabli">'+(l[n].content||"no  content")+"</li>"}}return o}()+"</ul>",success:function(n){var o=n.find(".layui-layer-title").children();var m=n.find(".layui-layer-tabmain").children();o.on("mousedown",function(r){r.stopPropagation?r.stopPropagation():r.cancelBubble=true;var q=e(this),p=q.index();q.addClass("layui-layer-tabnow").siblings().removeClass("layui-layer-tabnow");m.eq(p).show().siblings().hide();typeof k.change==="function"&&k.change(p)})}},k))};f.photos=function(u,p,s){var m={};u=u||{};if(!u.photos){return}var q=u.photos.constructor===Object;var t=q?u.photos:{},o=t.data||[];var l=t.start||0;m.imgIndex=(l|0)+1;u.img=u.img||"img";if(!q){var r=e(u.photos),n=function(){o=[];r.find(u.img).each(function(v){var w=e(this);w.attr("layer-index",v);o.push({alt:w.attr("alt"),pid:w.attr("layer-pid"),src:w.attr("layer-src")||w.attr("src"),thumb:w.attr("src")})})};n();if(o.length===0){return}p||r.on("click",u.img,function(){var w=e(this),v=w.attr("layer-index");f.photos(e.extend(u,{photos:{start:v,data:o,tab:u.tab},full:u.full}),true);n()});if(!p){return}}else{if(o.length===0){return f.msg("&#x6CA1;&#x6709;&#x56FE;&#x7247;")}}m.imgprev=function(v){m.imgIndex--;if(m.imgIndex<1){m.imgIndex=o.length}m.tabimg(v)};m.imgnext=function(v,w){m.imgIndex++;if(m.imgIndex>o.length){m.imgIndex=1;if(w){return}}m.tabimg(v)};m.keyup=function(w){if(!m.end){var v=w.keyCode;w.preventDefault();if(v===37){m.imgprev(true)}else{if(v===39){m.imgnext(true)}else{if(v===27){f.close(m.index)}}}}};m.tabimg=function(v){if(o.length<=1){return}t.start=m.imgIndex-1;f.close(m.index);f.photos(u,true,v)};m.event=function(){m.bigimg.hover(function(){m.imgsee.show()},function(){m.imgsee.hide()});m.bigimg.find(".layui-layer-imgprev").on("click",function(v){v.preventDefault();m.imgprev()});m.bigimg.find(".layui-layer-imgnext").on("click",function(v){v.preventDefault();m.imgnext()});e(document).on("keyup",m.keyup)};function k(x,y,w){var v=new Image();v.src=x;if(v.complete){return y(v)}v.onload=function(){v.onload=null;y(v)};v.onerror=function(z){v.onerror=null;w(z)}}m.loadi=f.load(1,{shade:"shade" in u?false:0.9,scrollbar:false});k(o[l].src,function(v){f.close(m.loadi);m.index=f.open(e.extend({type:1,area:function(){var x=[v.width,v.height];var w=[e(h).width()-50,e(h).height()-50];if(!u.full&&x[0]>w[0]){x[0]=w[0];x[1]=x[0]*v.height/v.width}return[x[0]+"px",x[1]+"px"]}(),title:false,shade:0.9,shadeClose:true,closeBtn:false,move:".layui-layer-phimg img",moveType:1,scrollbar:false,moveOut:true,shift:Math.random()*5|0,skin:"layui-layer-photos"+j("photos"),content:'<div class="layui-layer-phimg">'+'<img src="'+o[l].src+'" alt="'+(o[l].alt||"")+'" layer-pid="'+o[l].pid+'">'+'<div class="layui-layer-imgsee">'+(o.length>1?'<span class="layui-layer-imguide"><a href="javascript:;" class="layui-layer-iconext layui-layer-imgprev"></a><a href="javascript:;" class="layui-layer-iconext layui-layer-imgnext"></a></span>':"")+'<div class="layui-layer-imgbar" style="display:'+(s?"block":"")+'"><span class="layui-layer-imgtit"><a href="javascript:;">'+(o[l].alt||"")+"</a><em>"+m.imgIndex+"/"+o.length+"</em></span></div>"+"</div>"+"</div>",success:function(w,x){m.bigimg=w.find(".layui-layer-phimg");m.imgsee=w.find(".layui-layer-imguide,.layui-layer-imgbar");m.event(w);u.tab&&u.tab(o[l],w)},end:function(){m.end=true;e(document).off("keyup",m.keyup)}},u))},function(){f.close(m.loadi);f.msg("&#x5F53;&#x524D;&#x56FE;&#x7247;&#x5730;&#x5740;&#x5F02;&#x5E38;<br>&#x662F;&#x5426;&#x7EE7;&#x7EED;&#x67E5;&#x770B;&#x4E0B;&#x4E00;&#x5F20;&#xFF1F;",{time:30000,btn:["&#x4E0B;&#x4E00;&#x5F20;","&#x4E0D;&#x770B;&#x4E86;"],yes:function(){o.length>1&&m.imgnext(true,true)
}})})};i.run=function(){e=jQuery;g=e(h);c.html=e("html");f.open=function(l){var k=new b(l);return k.index}};"function"===typeof define?define(function(){i.run();f.use("skin/layer.css");return f}):function(){i.run();f.use("skin/layer.css")}()}(window);