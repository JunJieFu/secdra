(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-69bb3746"],{"0919":function(e,t,r){},e1f5:function(e,t,r){"use strict";r.r(t);var n=function(){var e=this,t=e.$createElement,r=e._self._c||t;return r("div",{staticClass:"default-margin"},[r("v-card",{staticClass:"default-padding"},[r("v-btn",{nativeOn:{click:function(t){return e.$router.back()}}},[e._v("返回")])],1),r("v-card",{staticClass:"default-padding",staticStyle:{"margin-top":"12px"}},[r("v-form",{staticClass:"demo-form-inline",attrs:{inline:!0}},[r("v-row",[r("v-col",{attrs:{cols:"12",sm:"3",md:"2"}},[r("v-btn",{on:{click:e.initIndex}},[e._v(" 初始化ES索引 ")])],1),r("v-col",{attrs:{cols:"12",sm:"3",md:"2"}},[r("v-btn",{on:{click:e.importES}},[e._v(" 将数据从数据库导入ES ")])],1)],1)],1),r("h4",[e._v("从文件夹加载图片（本地操作）")]),r("v-form",[r("v-row",[r("v-col",{attrs:{cols:"12",sm:"3",md:"2"}},[r("v-text-field",{attrs:{placeholder:"路径",clearable:"",dense:"",solo:"","hide-details":!0},model:{value:e.initForm.folderPath,callback:function(t){e.$set(e.initForm,"folderPath",t)},expression:"initForm.folderPath"}})],1),r("v-col",{attrs:{cols:"12",sm:"6",md:"4"}},[r("select-user",{model:{value:e.initForm.userId,callback:function(t){e.$set(e.initForm,"userId",t)},expression:"initForm.userId"}})],1),r("v-col",{attrs:{cols:"12",sm:"3",md:"2"}},[r("v-select",{attrs:{items:e.$enum.toArray(e.$enum.PrivacyState),"item-text":"label","item-value":"value",placeholder:"显示状态",dense:"",solo:"","hide-details":!0},model:{value:e.initForm.privacy,callback:function(t){e.$set(e.initForm,"privacy",t)},expression:"initForm.privacy"}})],1),r("v-col",{attrs:{cols:"12",sm:"3",md:"2"}},[r("v-btn",{on:{click:e.init}},[e._v(" 初始化 ")])],1)],1)],1),r("h4",[e._v("采集失败标识不再采集")]),r("v-form",[r("v-row",[r("v-col",{attrs:{cols:"12",sm:"3",md:"2"}},[r("v-text-field",{attrs:{placeholder:"状态码",clearable:"",dense:"",solo:"","hide-details":!0},model:{value:e.giveUpErrorForm.status,callback:function(t){e.$set(e.giveUpErrorForm,"status",t)},expression:"giveUpErrorForm.status"}})],1),r("v-col",{attrs:{cols:"12",sm:"3",md:"2"}},[r("v-btn",{on:{click:e.giveUpError}},[e._v("放弃标识")])],1)],1)],1),r("h4",[e._v("绑定用户（采集后处理）")]),r("v-form",[r("v-row",[r("v-col",{attrs:{cols:"12",sm:"6",md:"4"}},[r("SelectUser",{model:{value:e.bindUserForm.userId,callback:function(t){e.$set(e.bindUserForm,"userId",t)},expression:"bindUserForm.userId"}})],1),r("v-col",{attrs:{cols:"12",sm:"3",md:"2"}},[r("v-btn",{on:{click:e.bindUser}},[e._v("绑定用户")])],1)],1)],1)],1)],1)},o=[],s=(r("96cf"),r("1da1")),i=r("5530"),a=r("2f62"),c=r("3128"),l={components:{SelectUser:c["a"]},data:function(){return{initForm:{folderPath:"",userId:"",privacy:this.$enum.getKey(this.$enum.PrivacyState,this.$enum.PrivacyState.PUBLIC)},bindUserForm:{userId:""},giveUpErrorForm:{status:null}}},methods:Object(i["a"])({},Object(a["b"])("picture",["AInit","ABindUser","AInitIndex","AImportES","AGiveUpError"]),{init:function(){var e=this;return Object(s["a"])(regeneratorRuntime.mark((function t(){var r;return regeneratorRuntime.wrap((function(t){while(1)switch(t.prev=t.next){case 0:return t.next=2,e.AInit(e.initForm);case 2:r=t.sent,200===r.status?e.$notify({text:"成功",color:"success"}):e.$notify({text:"失败",color:"error"});case 4:case"end":return t.stop()}}),t)})))()},bindUser:function(){var e=this;return Object(s["a"])(regeneratorRuntime.mark((function t(){var r;return regeneratorRuntime.wrap((function(t){while(1)switch(t.prev=t.next){case 0:return t.next=2,e.ABindUser(e.bindUserForm);case 2:r=t.sent,200===r.status?e.$notify({text:"成功",color:"success"}):e.$notify({text:"失败",color:"error"});case 4:case"end":return t.stop()}}),t)})))()},initIndex:function(){var e=this;return Object(s["a"])(regeneratorRuntime.mark((function t(){var r;return regeneratorRuntime.wrap((function(t){while(1)switch(t.prev=t.next){case 0:return t.next=2,e.AInitIndex();case 2:r=t.sent,200===r.status?e.$notify({text:"成功",color:"success"}):e.$notify({text:"失败",color:"error"});case 4:case"end":return t.stop()}}),t)})))()},importES:function(){var e=this;return Object(s["a"])(regeneratorRuntime.mark((function t(){var r;return regeneratorRuntime.wrap((function(t){while(1)switch(t.prev=t.next){case 0:return t.next=2,e.AImportES();case 2:r=t.sent,200===r.status?e.$notify({text:"成功",color:"success"}):e.$notify({text:"失败",color:"error"});case 4:case"end":return t.stop()}}),t)})))()},giveUpError:function(){var e=this;return Object(s["a"])(regeneratorRuntime.mark((function t(){var r;return regeneratorRuntime.wrap((function(t){while(1)switch(t.prev=t.next){case 0:return t.next=2,e.AGiveUpError(e.giveUpErrorForm);case 2:r=t.sent,200===r.status?e.$notify({text:"成功",color:"success"}):e.$notify({text:"失败",color:"error"});case 4:case"end":return t.stop()}}),t)})))()}})},u=l,m=(r("fe23"),r("2877")),d=r("6544"),v=r.n(d),f=r("8336"),p=r("b0af"),b=r("62ad"),h=r("4bd4"),x=r("0fd9"),w=r("b974"),F=r("8654"),g=Object(m["a"])(u,n,o,!1,null,"b1f61fd8",null);t["default"]=g.exports;v()(g,{VBtn:f["a"],VCard:p["a"],VCol:b["a"],VForm:h["a"],VRow:x["a"],VSelect:w["a"],VTextField:F["a"]})},fe23:function(e,t,r){"use strict";var n=r("0919"),o=r.n(n);o.a}}]);
//# sourceMappingURL=chunk-69bb3746.ed94caf2.js.map