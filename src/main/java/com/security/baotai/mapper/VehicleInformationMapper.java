package com.security.baotai.mapper;

import com.security.baotai.model.VehicleInformation;
import com.security.baotai.model.VehicleInformationExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface VehicleInformationMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_vehicle_information
     *
     * @mbggenerated
     */
    int countByExample(VehicleInformationExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_vehicle_information
     *
     * @mbggenerated
     */
    int deleteByExample(VehicleInformationExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_vehicle_information
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_vehicle_information
     *
     * @mbggenerated
     */
    int insert(VehicleInformation record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_vehicle_information
     *
     * @mbggenerated
     */
    int insertSelective(VehicleInformation record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_vehicle_information
     *
     * @mbggenerated
     */
    List<VehicleInformation> selectByExample(VehicleInformationExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_vehicle_information
     *
     * @mbggenerated
     */
    VehicleInformation selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_vehicle_information
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") VehicleInformation record, @Param("example") VehicleInformationExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_vehicle_information
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") VehicleInformation record, @Param("example") VehicleInformationExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_vehicle_information
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(VehicleInformation record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_vehicle_information
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(VehicleInformation record);
}