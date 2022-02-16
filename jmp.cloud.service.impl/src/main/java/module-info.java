import jmp.cloud.service.impl.ServiceImpl;
import jmp.service.api.IService;

module jmp.cloud.service.impl {
    requires transitive jmp.service.api;
    requires jmp.dto;
    requires java.sql;
    exports jmp.cloud.service.impl;
    provides IService with ServiceImpl;
}