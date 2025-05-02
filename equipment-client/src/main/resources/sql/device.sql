-- 创建 device 表
DROP TABLE IF EXISTS device;
CREATE TABLE device (
    id BIGINT AUTO_INCREMENT PRIMARY KEY COMMENT '设备实体的唯一标识，自增主键',
    code VARCHAR(255) COMMENT '设备编码',
    name VARCHAR(255) COMMENT '设备名称',
    device_type INT COMMENT '设备类型',
    running_state INT COMMENT '设备运行状态',
    last_update_running_state_time DATETIME,
    remark TEXT COMMENT '备注信息',
    created_user_id VARCHAR(255) COMMENT '创建人设备 ID',
    created_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    updated_user_id VARCHAR(255) COMMENT '更新人设备 ID',
    updated_time TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    UNIQUE KEY uk_code (code)
) COMMENT = '设备实体表';
