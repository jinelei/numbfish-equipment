-- 创建 structure 表
DROP TABLE IF EXISTS structure;
CREATE TABLE structure (
    id BIGINT AUTO_INCREMENT PRIMARY KEY COMMENT '结构实体的唯一标识，自增主键',
    code VARCHAR(255) COMMENT '结构编码',
    name VARCHAR(255) COMMENT '结构名称',
    parent_id BIGINT COMMENT '父级结构id',
    type INT COMMENT '结构类型',
    remark TEXT COMMENT '备注信息',
    created_user_id VARCHAR(255) COMMENT '创建人结构 ID',
    created_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    updated_user_id VARCHAR(255) COMMENT '更新人结构 ID',
    updated_time TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    UNIQUE KEY uk_code (code)
) COMMENT = '结构实体表';
