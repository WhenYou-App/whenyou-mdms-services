-- Table: m_districts
CREATE TABLE m_districts (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    excel_id BIGINT NOT NULL UNIQUE, -- Excel ID stored here
    name VARCHAR(150) NOT NULL,
    name_in_local VARCHAR(150),
    status BOOLEAN DEFAULT TRUE,
    created_at TIMESTAMP,
    created_by UUID,
    modified_by UUID,
    modified_date TIMESTAMP
);

-- Table: m_pincode
CREATE TABLE m_pincode (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    excel_id BIGINT NOT NULL UNIQUE, -- Excel ID stored here
    name VARCHAR(150) NOT NULL,
    name_in_local VARCHAR(150),
    pincode VARCHAR(10) NOT NULL,
    status BOOLEAN DEFAULT TRUE,
    created_at TIMESTAMP,
    created_by UUID,
    modified_by UUID,
    modified_date TIMESTAMP
);