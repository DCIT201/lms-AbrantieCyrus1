farm [icon: user, color: blue] {
  FarmId int pk
  Name string
  Location string
  Size int
}

farmer [icon: users, color: blue] {
  FarmerId int pk
  Name string
  ContactInfo string
  Experience int
  FarmId int
    
   
}

crop [icon: home] {
  CropId string
  Name string
  Type string
  PlantingSeason string
  HarvestSeason string
  FarmId int
   
}

soil [icon: folder] {
  SoilId int
  pHLevel int
  Type string
  NutrientContent string
  FarmId int
}

equipment [icon: message-circle, color: green] {
  EquipmentID int
  Name string
  Type string
  PurchaseDate date
  Condition string
  FarmID int
}

irrigation [icon: mail, color: green] {
  IrrigationID  int
  Type string
  WaterSource string
  CoverageArea int
  FarmID int
}

farms.farmerId > farmers.id
crops.farmId > farms.id
irrigation.farmId > farms.id
soil.farmId > farms.id
irrigation.cropId > crops.id
soil.cropId > crops.id
equipment.cropId > crops.id