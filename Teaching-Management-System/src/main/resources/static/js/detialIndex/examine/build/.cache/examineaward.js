/*TMODJS:{"version":73,"md5":"960e7cb00c42e77ca46408bdc7c0b523"}*/
template('examineaward',function($data,$filename
) {
'use strict';var $utils=this,$helpers=$utils.$helpers,$escape=$utils.$escape,number=$data.number,pwinner=$data.pwinner,category=$data.category,pname=$data.pname,level=$data.level,title=$data.title,psponsor=$data.psponsor,ptime=$data.ptime,tname=$data.tname,plevel=$data.plevel,$each=$utils.$each,pathFront=$data.pathFront,$value=$data.$value,$index=$data.$index,$out='';$out+='<form action="" name="review-award" method="" id="review-form"> <div class="review-info"> <div class="certif"> <label for="certif-id">证书编号:</label> <span>';
$out+=$escape(number);
$out+='</span> </div> <div class="contestants"> <label for="contest-name">参赛人姓名:</label> <span>';
$out+=$escape(pwinner);
$out+='</span> </div> <div class="contest-type"> <label for="type">比赛类型:</label> <span>';
$out+=$escape(category == 0 ?'单人':'团体');
$out+='</span> </div> <div class="contest-name"> <label for="contest-name">比赛名称:</label> <span>';
$out+=$escape(pname);
$out+='</span> </div> <div class="award-level"> <label for="award-level">获奖等级: </label> <span>';
$out+=$escape(level);
$out+='</span> </div> <div class="award-design"> <label for="award-design">称号:</label> <span>';
$out+=$escape(title);
$out+='</span> </div> <div class="organize"> <label for="organize">发证机构:</label> <span>';
$out+=$escape(psponsor);
$out+='</span> </div> <div class="data"> <label for="data">发证日期: </label> <span>';
$out+=$escape(ptime);
$out+='</span> </div> <div class="adsive-tea"> <label for="adsive-tea">指导老师: </label> <span>';
$out+=$escape(tname);
$out+='</span> </div> <div class="awade-type"> <label for="awade-type">奖项分类:</label> <span>';
$out+=$escape(plevel);
$out+='</span> </div> </div> <div class="preview-awardimg"> ';
$each(pathFront,function($value,$index){
$out+=' <div> <span>';
$out+=$escape(pname);
$out+='奖项材料';
$out+=$escape($index+1);
$out+='</span> <button id="btn-img">预览</button> </div> <div id="box-img" class="file-lists"> <span class="iconfont icon-guanbi close"></span> <img src="';
$out+=$escape($value);
$out+='" alt=""> </div> ';
});
$out+=' </div> </form>';
return new String($out);
});