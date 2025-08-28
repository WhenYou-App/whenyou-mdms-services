-- Table: m_districts
CREATE TABLE m_districts (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    district_id BIGINT NOT NULL UNIQUE,
    name VARCHAR(150) NOT NULL,
    name_in_local VARCHAR(150),
    status BOOLEAN DEFAULT TRUE
);

-- Table: m_pincodes
CREATE TABLE m_pincodes (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    pincode_id BIGINT NOT NULL UNIQUE,
    district_id BIGINT NOT NULL,
    name VARCHAR(150) NOT NULL,
    name_in_local VARCHAR(150),
    pincode VARCHAR(10) NOT NULL,
    status BOOLEAN DEFAULT TRUE
);

-- Table: m_vehicle_brands
CREATE TABLE m_vehicle_brands (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    brand_id BIGINT NOT NULL UNIQUE,
    brand_name VARCHAR(150) NOT NULL,
    name_in_local VARCHAR(150),
    status BOOLEAN DEFAULT TRUE
);

-- Table: m_vehicle_model_types
CREATE TABLE m_vehicle_model_types (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    model_type_id BIGINT NOT NULL UNIQUE,
    model_type_name VARCHAR(150) NOT NULL,
    name_in_local VARCHAR(150),
    status BOOLEAN DEFAULT TRUE
);

-- Table: m_vehicle_model_names
CREATE TABLE m_vehicle_model_names (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    model_name_id BIGINT NOT NULL UNIQUE,
    model_type_id BIGINT NOT NULL ,
    brand_id BIGINT NOT NULL,
    model_name VARCHAR(150) NOT NULL,
    name_in_local VARCHAR(150),
    status BOOLEAN DEFAULT TRUE
);

-- Table: m_jewel_product_types
CREATE TABLE m_jewel_product_types (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    jewel_product_type_id BIGINT NOT NULL UNIQUE,
    product_type_name VARCHAR(150) NOT NULL,
    name_in_local VARCHAR(150),
    status BOOLEAN DEFAULT TRUE
);

-- Table: m_jewel_materials
CREATE TABLE m_jewel_materials (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    jewel_material_id BIGINT NOT NULL UNIQUE,
    material_name VARCHAR(150),
    name_in_local VARCHAR(150),
    status BOOLEAN DEFAULT TRUE
);

-- Table: m_jewel_material_purities
CREATE TABLE m_jewel_material_purities (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    jewel_material_purity_id BIGINT NOT NULL UNIQUE,
    jewel_material_id BIGINT NOT NULL,
    material_purity VARCHAR(150),
    status BOOLEAN DEFAULT TRUE
);
-- Table: m_serve_types
CREATE TABLE m_serve_types (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    serve_type_id BIGINT NOT NULL UNIQUE,
    serve_type VARCHAR(150) NOT NULL,
    name_in_local VARCHAR(150),
    status BOOLEAN DEFAULT TRUE
);

-- Table: m_make_over_categories
CREATE TABLE m_make_over_categories (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    category_id BIGINT NOT NULL UNIQUE,
    category_name VARCHAR(150) NOT NULL,
    name_in_local VARCHAR(150) NOT NULL,
    status BOOLEAN DEFAULT TRUE
);
-- Table: m_make_over_packages
CREATE TABLE m_make_over_packages (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    package_id BIGINT NOT NULL UNIQUE,
    category_id BIGINT NOT NULL,
    package_name VARCHAR(150) NOT NULL,
    name_in_local VARCHAR(150) NOT NULL,
    status BOOLEAN DEFAULT TRUE
);

-- Table: m_boutique_wear_categories
CREATE TABLE m_boutique_wear_categories (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    category_id BIGINT NOT NULL UNIQUE,
    category_name VARCHAR(150),
    name_in_local VARCHAR(150),
    status BOOLEAN DEFAULT TRUE
);

-- Table: m_boutique_wears
CREATE TABLE m_boutique_wears (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    boutique_wear_id BIGINT NOT NULL UNIQUE,
    category_id BIGINT NOT NULL,
    type_of_wear VARCHAR(150) NOT NULL,
    name_in_local VARCHAR(150),
    status BOOLEAN DEFAULT TRUE
);

-- Table: m_boutique_wear_brands
CREATE TABLE m_boutique_wear_brands (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    boutique_wear_brand_id BIGINT NOT NULL UNIQUE,
    category_id BIGINT NOT NULL,
    brand_name VARCHAR(150) NOT NULL,
    name_in_local VARCHAR(150),
    status BOOLEAN DEFAULT TRUE
);

-- Table: m_textile_wear_categories
CREATE TABLE m_textile_wear_categories (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    category_id BIGINT NOT NULL UNIQUE,
    category_name VARCHAR(150),
    name_in_local VARCHAR(150),
    status BOOLEAN DEFAULT TRUE
);

-- Table: m_textile_wears
CREATE TABLE m_textile_wears (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    textile_wear_id BIGINT NOT NULL UNIQUE,
    category_id BIGINT NOT NULL,
    type_of_wear VARCHAR(150) NOT NULL,
    name_in_local VARCHAR(150),
    status BOOLEAN DEFAULT TRUE
);

-- Table: m_textile_wear_brands
CREATE TABLE m_textile_wear_brands (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    textile_wear_brand_id BIGINT NOT NULL UNIQUE,
    category_id BIGINT NOT NULL,
    brand_name VARCHAR(150) NOT NULL,
    name_in_local VARCHAR(150),
    status BOOLEAN DEFAULT TRUE
);

-- Table: m_food_categories
CREATE TABLE m_food_categories (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    food_category_id BIGINT NOT NULL UNIQUE,
    category_name VARCHAR(150) NOT NULL,
    name_in_local VARCHAR(150),
    status BOOLEAN DEFAULT TRUE
);