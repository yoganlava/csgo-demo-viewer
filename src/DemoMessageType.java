public enum DemoMessageType {
    // Demo start up message
    DEM_SIGNON,
    // Network packet
    DEM_PACKET,
    // Sync client clock to demo tick
    DEM_SYNCTICK,
    // Console command
    DEM_CONSOLECMD,
    // User input
    DEM_USERCMD,
    //  Network Data Tables
    DEM_DATATABLES,
    // End of demo/time
    DEM_STOP,
    // Custom blob
    DEM_CUSTOMDATA
}
