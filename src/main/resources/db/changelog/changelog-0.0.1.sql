-- Table: m_districts
CREATE TABLE m_districts (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    name VARCHAR(150) NOT NULL,
    name_in_local VARCHAR(150),
    status BOOLEAN DEFAULT TRUE
);

-- Table: m_pincode
CREATE TABLE m_pincode (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    name VARCHAR(150) NOT NULL,
    name_in_local VARCHAR(150),
    pincode VARCHAR(10) NOT NULL,
    status BOOLEAN DEFAULT TRUE
);