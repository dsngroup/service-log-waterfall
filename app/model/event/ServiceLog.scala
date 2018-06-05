/*
 * Copyright 2018 Dependable Distributed System and Network Lab, National Taiwan University.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package model.event

import play.api.libs.functional.syntax._
import play.api.libs.json._

object ServiceLogHelper {

  case class ServiceLog(id: String, duration: String, statusCode: Int, service: String, timestamp: String)

  implicit val serviceLogWrites = new Writes[ServiceLog] {
    override def writes(le: ServiceLog): JsValue = Json.obj(
      "id" -> le.id,
      "duration" -> le.duration,
      "status-code" -> le.statusCode,
      "service" -> le.service,
      "timestamp" -> le.timestamp
    )
  }

  implicit val serviceLogReads: Reads[ServiceLog] = (
    (JsPath \ "id").read[String] and
      (JsPath \ "duration").read[String] and
      (JsPath \ "status-code").read[Int] and
      (JsPath \ "service").read[String] and
      (JsPath \ "timestamp").read[String]
    ) (ServiceLog.apply _)
}
