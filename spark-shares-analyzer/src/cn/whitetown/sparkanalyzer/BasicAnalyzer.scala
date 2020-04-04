package cn.whitetown.sparkanalyzer

import java.util

import cn.whitetown.dao.BasicSharesInfo
import org.apache.spark.{SparkConf, SparkContext}

/**
 *
 * @author GrainRain
 * @date 2020/04/02 11:42
 *
 **/
object BasicAnalyzer {
  def main(args: Array[String]): Unit = {
    basicInfoAreaAnalyzer()
  }

  def basicInfoAreaAnalyzer(): Unit ={
    val conf = new SparkConf().setMaster("local").setAppName("basicAnalyzer")
    val sc = new SparkContext(conf)
    val dataSource = sc.textFile("file:///Users/taixian/Documents/static/data/basicSSE.txt")
    val data = dataSource.map{line=>
      val info = line.split("\\|")
      (info(0),info(1),info(2),info(3),info(4),info(5))
    }
    val areaTongJi = data.map(x=>(x._4,1)).reduceByKey(_+_).collect()
    val areaMap = new util.LinkedHashMap[String,Integer]();
    for(i <- 0 until  areaTongJi.length){
      areaMap.put(areaTongJi(i)._1,areaTongJi(i)._2)
    }
    val bool = BasicSharesInfo.saveAreaAnalyzer(areaMap)
    println(bool)
  }
}
