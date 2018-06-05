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

package controllers.apis

import javax.inject.Inject
import play.api.libs.json.{JsError, Json}
import play.api.mvc._

class LoggingExtractor @Inject()(cc: ControllerComponents) extends AbstractController(cc) {

  import models.event.ServiceLogHelper._

  def mark = Action(parse.json) { implicit request =>

    val markLoggingResult = request.body.validate[ServiceLog]

    markLoggingResult.fold(
      err => {
        BadRequest(Json.obj("status" -> 1, "message" -> JsError.toJson(err)))
      },
      slog => {
        Ok(Json.obj("status" -> 0, "message" -> s"${slog.id} is successfully marked."))
      }
    )
  }

  def list = Action { implicit request =>
    Ok(Json.obj("status" -> 0, "message" -> s"listing 1000 lines of stored logs."))
  }
}
