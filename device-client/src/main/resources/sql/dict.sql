-- 创建 dict 表
DROP TABLE IF EXISTS dict;
CREATE TABLE dict (
    id BIGINT AUTO_INCREMENT PRIMARY KEY COMMENT '字典实体的唯一标识，自增主键',
    code VARCHAR(255) COMMENT '字典编码',
    name VARCHAR(255) COMMENT '字典名称',
    val VARCHAR(255) COMMENT '字典值',
    sort INT COMMENT '排序值',
    parent_id BIGINT COMMENT '父级字典id',
    remark TEXT COMMENT '备注信息',
    created_user_id VARCHAR(255) COMMENT '创建人字典 ID',
    created_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    updated_user_id VARCHAR(255) COMMENT '更新人字典 ID',
    updated_time TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    UNIQUE KEY uk_code (code)
) COMMENT = '字典实体表';
