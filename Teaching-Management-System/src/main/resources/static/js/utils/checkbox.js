window.addEventListener('load',function(){
	var oBtn = document.getElementById('award-add');
	oBtn.onclick = function(){
		document.getElementById('upload').click();
	}
	var aCheckAll = document.querySelectorAll('.check-all');
	//全选框事件：选中tbody标签下的所有复选框
	var aCheckBox = document.querySelectorAll('.check-box');
	for (var i = 0; i < aCheckAll.length; i++) { 
		aCheckAll[i].index = i;
		aCheckAll[i].onclick = function(){
			var aCheckBox_input = aCheckBox[this.index].querySelectorAll('.td-checkbox');
			var this_ = this;
			//点击全选按钮之后触发全选事件：把当前的全选框状态赋值给当前全选框下的所有复选框
			for (var j = 0; j < aCheckBox_input.length; j++) {
				aCheckBox_input[j].checked = this.checked;
			}
			//点击所有复选框按钮之后触发全选事件：当前全选框被选中
			for (var j = 0; j < aCheckBox_input.length; j++) {
				aCheckBox_input[j].onclick = function(){
					flag = true;
					for(var j = 0, length1 = aCheckBox_input.length; j < length1; j++){
						if(!aCheckBox_input[j].checked){
							flag = false;
							break;
						}
					}
					aCheckAll[this_.index].checked = flag;
				}
			}
		}
	}
});



	