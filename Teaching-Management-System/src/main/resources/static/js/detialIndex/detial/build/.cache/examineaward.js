/*TMODJS:{"version":20,"md5":"a3677880f9fdd8ef0f340bee6bf5014a"}*/
template('examineaward',function($data,$filename
) {
'use strict';var $utils=this,$helpers=$utils.$helpers,$escape=$utils.$escape,obj=$data.obj,$out='';$out+='<form action="" name="review-award" method="" id="review-form"> <div class="review-info"> <div class="certif"> <label for="certif-id">证书编号:</label> <span>';
$out+=$escape(obj.number);
$out+='</span> </div> <div class="contestants"> <label for="contest-name">参赛人姓名:</label> <span>';
$out+=$escape(obj.pwinner);
$out+='</span> </div> <div class="contest-type"> <label for="type">比赛类型:</label> <span>';
$out+=$escape(obj.category == 0 ?'单人':'团体');
$out+='</span> </div> <div class="contest-name"> <label for="contest-name">比赛名称:</label> <span>';
$out+=$escape(obj.pname);
$out+='</span> </div> <div class="award-level"> <label for="award-level">获奖等级: </label> <span>';
$out+=$escape(obj.level);
$out+='</span> </div> <div class="award-design"> <label for="award-design">称号:</label> <span>';
$out+=$escape(obj.title);
$out+='</span> </div> <div class="organize"> <label for="organize">发证机构:</label> <span>';
$out+=$escape(obj.psponsor);
$out+='</span> </div> <div class="data"> <label for="data">发证日期: </label> <span>';
$out+=$escape(obj.ptime);
$out+='</span> </div> <div class="adsive-tea"> <label for="adsive-tea">指导老师: </label> <span>';
$out+=$escape(obj.tname);
$out+='</span> </div> <div class="awade-type"> <label for="awade-type">奖项分类:</label> <span>';
$out+=$escape(obj.plevel);
$out+='</span> </div> </div> <div class="preview-awardimg"> <span>';
$out+=$escape(obj.pathFront);
$out+='</span>  <input type="button" value="预览" name="look"> > </div> </form>';
return new String($out);
});