/*TMODJS:{"version":"1.0.0"}*/
!function(){function a(a,b){return(/string|function/.test(typeof b)?h:g)(a,b)}function b(a,c){return"string"!=typeof a&&(c=typeof a,"number"===c?a+="":a="function"===c?b(a.call(a)):""),a}function c(a){return l[a]}function d(a){return b(a).replace(/&(?![\w#]+;)|[<>"']/g,c)}function e(a,b){if(m(a))for(var c=0,d=a.length;d>c;c++)b.call(a,a[c],c,a);else for(c in a)b.call(a,a[c],c)}function f(a,b){var c=/(\/)[^/]+\1\.\.\1/,d=("./"+a).replace(/[^/]+$/,""),e=d+b;for(e=e.replace(/\/\.\//g,"/");e.match(c);)e=e.replace(c,"/");return e}function g(b,c){var d=a.get(b)||i({filename:b,name:"Render Error",message:"Template not found"});return c?d(c):d}function h(a,b){if("string"==typeof b){var c=b;b=function(){return new k(c)}}var d=j[a]=function(c){try{return new b(c,a)+""}catch(d){return i(d)()}};return d.prototype=b.prototype=n,d.toString=function(){return b+""},d}function i(a){var b="{Template Error}",c=a.stack||"";if(c)c=c.split("\n").slice(0,2).join("\n");else for(var d in a)c+="<"+d+">\n"+a[d]+"\n\n";return function(){return"object"==typeof console&&console.error(b+"\n\n"+c),b}}var j=a.cache={},k=this.String,l={"<":"&#60;",">":"&#62;",'"':"&#34;","'":"&#39;","&":"&#38;"},m=Array.isArray||function(a){return"[object Array]"==={}.toString.call(a)},n=a.utils={$helpers:{},$include:function(a,b,c){return a=f(c,a),g(a,b)},$string:b,$escape:d,$each:e},o=a.helpers=n.$helpers;a.get=function(a){return j[a.replace(/^\.\//,"")]},a.helper=function(a,b){o[a]=b},"function"==typeof define?define(function(){return a}):"undefined"!=typeof exports?module.exports=a:this.template=a,/*v:50*/
a("examineaward",function(a){"use strict";var b=this,c=(b.$helpers,b.$escape),d=a.obj,e="";return e+='<form action="" name="review-award" method="" id="review-form"> <div class="review-info"> <div class="certif"> <label for="certif-id">\u8bc1\u4e66\u7f16\u53f7:</label> <span>',e+=c(d.number),e+='</span> </div> <div class="contestants"> <label for="contest-name">\u53c2\u8d5b\u4eba\u59d3\u540d:</label> <span>',e+=c(d.pwinner),e+='</span> </div> <div class="contest-type"> <label for="type">\u6bd4\u8d5b\u7c7b\u578b:</label> <span>',e+=c(0==d.category?"\u5355\u4eba":"\u56e2\u4f53"),e+='</span> </div> <div class="contest-name"> <label for="contest-name">\u6bd4\u8d5b\u540d\u79f0:</label> <span>',e+=c(d.pname),e+='</span> </div> <div class="award-level"> <label for="award-level">\u83b7\u5956\u7b49\u7ea7: </label> <span>',e+=c(d.level),e+='</span> </div> <div class="award-design"> <label for="award-design">\u79f0\u53f7:</label> <span>',e+=c(d.title),e+='</span> </div> <div class="organize"> <label for="organize">\u53d1\u8bc1\u673a\u6784:</label> <span>',e+=c(d.psponsor),e+='</span> </div> <div class="data"> <label for="data">\u53d1\u8bc1\u65e5\u671f: </label> <span>',e+=c(d.ptime),e+='</span> </div> <div class="adsive-tea"> <label for="adsive-tea">\u6307\u5bfc\u8001\u5e08: </label> <span>',e+=c(d.tname),e+='</span> </div> <div class="awade-type"> <label for="awade-type">\u5956\u9879\u5206\u7c7b:</label> <span>',e+=c(d.plevel),e+='</span> </div> </div> <div class="preview-awardimg"> <span>',e+=c(d.pathFront),e+='</span> <button id="btn-img">\u9884\u89c8</button> <div id="box-img" class="file-lists"> <span class="iconfont icon-guanbi close"></span> <img src="',e+=c(d.src),e+='" alt=""> </div> </div> </form>',new k(e)})}();