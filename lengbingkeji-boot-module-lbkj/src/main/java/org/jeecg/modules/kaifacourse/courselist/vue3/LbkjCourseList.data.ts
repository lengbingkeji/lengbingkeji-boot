import {BasicColumn} from '/@/components/Table';
import {FormSchema} from '/@/components/Table';
import { rules} from '/@/utils/helper/validator';
import { render } from '/@/utils/common/renderUtils';
//列表数据
export const columns: BasicColumn[] = [
   {
    title: '课程名称',
    align:"center",
    dataIndex: 'name'
   },
   {
    title: '价格',
    align:"center",
    dataIndex: 'price'
   },
   {
    title: '开课时间',
    align:"center",
    dataIndex: 'kaikeDate'
   },
   {
    title: '课程简介',
    align:"center",
    dataIndex: 'contents',
    slots: { customRender: 'htmlSlot' },
   },
   {
    title: '课程分类',
    align:"center",
    dataIndex: 'courseTypeId_dictText'
   },
];
//查询数据
export const searchFormSchema: FormSchema[] = [
	{
      label: "课程名称",
      field: 'name',
      component: 'Input',
      colProps: {span: 6},
 	},
	{
      label: "价格",
      field: 'price',
      component: 'Input',
      colProps: {span: 6},
 	},
     {
      label: "开课时间",
      field: "kaikeDate",
      component: 'RangePicker',
      componentProps: {
          showTime:true
      },
      colProps: {span: 6},
	},
	{
      label: "课程分类",
      field: 'courseTypeId',
      component: 'Input',
      colProps: {span: 6},
 	},
];
//表单数据
export const formSchema: FormSchema[] = [
  {
    label: '课程名称',
    field: 'name',
    component: 'Input',
  },
  {
    label: '价格',
    field: 'price',
    component: 'InputNumber',
  },
  {
    label: '开课时间',
    field: 'kaikeDate',
    component: 'DatePicker',
    componentProps: {
       showTime: true,
       valueFormat: 'YYYY-MM-DD HH:mm:ss'
     },
  },
  {
    label: '课程简介',
    field: 'contents',
    component: 'JEditor',
  },
  {
    label: '课程分类',
    field: 'courseTypeId',
    component: 'JTreeSelect',
    componentProps:{
        dict:"lbkj_course_type,name,id",
        pidValue:"0",
    },
  },
	// TODO 主键隐藏字段，目前写死为ID
	{
	  label: '',
	  field: 'id',
	  component: 'Input',
	  show: false
	},
];
