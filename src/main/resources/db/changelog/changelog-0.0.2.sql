-- Table: m_jewels
CREATE TABLE m_jewels (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    excel_id BIGINT NOT NULL UNIQUE,
    product_type VARCHAR(150) NOT NULL,
    status BOOLEAN DEFAULT TRUE,
    created_at TIMESTAMP,
    created_by UUID,
    modified_by UUID,
    modified_date TIMESTAMP
);

-- Table: m_jewel_materials
CREATE TABLE m_jewel_materials (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    excel_id BIGINT NOT NULL UNIQUE,
    material VARCHAR(150),
    purity VARCHAR(150),
    status BOOLEAN DEFAULT TRUE,
    created_at TIMESTAMP,
    created_by UUID,
    modified_by UUID,
    modified_date TIMESTAMP
);

-- Table: m_serve_types
CREATE TABLE m_serve_types (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    excel_id BIGINT NOT NULL UNIQUE,
    serve_type VARCHAR(150) NOT NULL,
    status BOOLEAN DEFAULT TRUE,
    created_at TIMESTAMP,
    created_by UUID,
    modified_by UUID,
    modified_date TIMESTAMP
);

-- Table: m_make_overs
CREATE TABLE m_make_overs (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    excel_id BIGINT NOT NULL UNIQUE,
    package VARCHAR(150) NOT NULL,
    category VARCHAR(150) NOT NULL,
    status BOOLEAN DEFAULT TRUE,
    created_at TIMESTAMP,
    created_by UUID,
    modified_by UUID,
    modified_date TIMESTAMP
);

-- Table: m_boutique_wears
CREATE TABLE m_boutique_wears (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    excel_id BIGINT NOT NULL UNIQUE,
    type_of_wear VARCHAR(150) NOT NULL,
    category VARCHAR(150),
    attire_type VARCHAR(150),
    status BOOLEAN DEFAULT TRUE,
    created_at TIMESTAMP,
    created_by UUID,
    modified_by UUID,
    modified_date TIMESTAMP
);

-- Table: m_boutique_wear_brands
CREATE TABLE m_boutique_wear_brands (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    excel_id BIGINT NOT NULL UNIQUE,
    brand_name VARCHAR(150) NOT NULL,
    category VARCHAR(150) NOT NULL,
    attire_type VARCHAR(150),
    status BOOLEAN DEFAULT TRUE,
    created_at TIMESTAMP,
    created_by UUID,
    modified_by UUID,
    modified_date TIMESTAMP
);

