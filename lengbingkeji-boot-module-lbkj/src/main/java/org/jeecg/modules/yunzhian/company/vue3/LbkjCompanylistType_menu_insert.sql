-- 注意：该页面对应的前台目录为views/company文件夹下
-- 如果你想更改到其他目录，请修改sql中component字段对应的值


INSERT INTO sys_permission(id, parent_id, name, url, component, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_route, is_leaf, keep_alive, hidden, hide_tab, description, status, del_flag, rule_flag, create_by, create_time, update_by, update_time, internal_or_external) 
VALUES ('2022092803481910450', NULL, '监管对象类型', '/company/lbkjCompanylistTypeList', 'company/LbkjCompanylistTypeList', NULL, NULL, 0, NULL, '1', 1.00, 0, NULL, 1, 1, 0, 0, 0, NULL, '1', 0, 0, 'admin', '2022-09-28 15:48:45', NULL, NULL, 0);

-- 权限控制sql
-- 新增
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2022092803481910451', '2022092803481910450', '添加监管对象类型', NULL, NULL, 0, NULL, NULL, 2, 'org.jeecg.modules.yunzhian:lbkj_companylist_type:add', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2022-09-28 15:48:45', NULL, NULL, 0, 0, '1', 0);
-- 编辑
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2022092803481910452', '2022092803481910450', '编辑监管对象类型', NULL, NULL, 0, NULL, NULL, 2, 'org.jeecg.modules.yunzhian:lbkj_companylist_type:edit', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2022-09-28 15:48:45', NULL, NULL, 0, 0, '1', 0);
-- 删除
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2022092803481910453', '2022092803481910450', '删除监管对象类型', NULL, NULL, 0, NULL, NULL, 2, 'org.jeecg.modules.yunzhian:lbkj_companylist_type:delete', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2022-09-28 15:48:45', NULL, NULL, 0, 0, '1', 0);
-- 批量删除
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2022092803481910454', '2022092803481910450', '批量删除监管对象类型', NULL, NULL, 0, NULL, NULL, 2, 'org.jeecg.modules.yunzhian:lbkj_companylist_type:deleteBatch', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2022-09-28 15:48:45', NULL, NULL, 0, 0, '1', 0);
-- 导出excel
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2022092803481910455', '2022092803481910450', '导出excel_监管对象类型', NULL, NULL, 0, NULL, NULL, 2, 'org.jeecg.modules.yunzhian:lbkj_companylist_type:exportXls', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2022-09-28 15:48:45', NULL, NULL, 0, 0, '1', 0);
-- 导入excel
INSERT INTO sys_permission(id, parent_id, name, url, component, is_route, component_name, redirect, menu_type, perms, perms_type, sort_no, always_show, icon, is_leaf, keep_alive, hidden, hide_tab, description, create_by, create_time, update_by, update_time, del_flag, rule_flag, status, internal_or_external)
VALUES ('2022092803481910456', '2022092803481910450', '导入excel_监管对象类型', NULL, NULL, 0, NULL, NULL, 2, 'org.jeecg.modules.yunzhian:lbkj_companylist_type:importExcel', '1', NULL, 0, NULL, 1, 0, 0, 0, NULL, 'admin', '2022-09-28 15:48:45', NULL, NULL, 0, 0, '1', 0);