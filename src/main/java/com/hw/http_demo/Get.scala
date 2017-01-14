package com.hw.http_demo

import scala.collection.immutable.Map
import scala.collection.mutable.HashMap

import org.junit.Test

import scalaj.http.Http
import scalaj.http.HttpResponse

class Get {

  @Test
  def getWithoutParamTest(): Unit = {
    val url = "http://www.jianshu.com"
    val response = this.get(url)
    println(response.body)
  }

  @Test
  def getWithParamTest(): Unit = {
    val url = "http://127.0.0.1:8080/article/articleGetByName"

    var paramMap = Map[String, String]()
    paramMap += ("name" -> "nanquan")
    paramMap += ("moduleId" -> "8989")

    val response = this.get(url, paramMap)
    println(response.body)
  }

  def get(url: String): HttpResponse[String] = {
    Http(url).asString
  }

  def get(url: String, paramMap: Map[String, String]): HttpResponse[String] = {
    Http(url).params(paramMap).asString
  }

}