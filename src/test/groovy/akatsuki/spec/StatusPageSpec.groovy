package akatsuki.spec

import akatsuki.page.admin.AdminStatusPage
import akatsuki.path.PathFixture
import akatsuki.path.PathPresentation

class StatusPageSpec extends BaseSpecification {

  def setupSpec() {
    login()
  }

  def cleanupSpec() {
    logout()
  }

  def setup() {
    presentation.get(path: PathFixture.RESET)
  }

  def "Status page renders status of the application"() {
    given:
      def applicationVersion = presentation.get(path: PathFixture.STATUS_APPLICATION_VERSION).data.applicationVersion
      def gitCommitHash = presentation.get(path: PathFixture.STATUS_COMMIT_HASH).data.commitHash

    when:
      toAt AdminStatusPage

    then:
      waitFor { status('application').header.text() == 'APPLICATION' }
      status('application').rows[0].cells*.text() == ["applicationVersion", applicationVersion]
      status('application').rows[1].cells*.text() == ["commitHash", gitCommitHash]

    and:
      status('health').header.text() == 'HEALTH'
      status('health').rows[0].cells*.text() == ["up", "OK"]
  }

  def "Status page renders status of the application by section"() {
    given:
      def applicationVersion = presentation.get(path: PathFixture.STATUS_APPLICATION_VERSION).data.applicationVersion
      def gitCommitHash = presentation.get(path: PathFixture.STATUS_COMMIT_HASH).data.commitHash

    when:
      toAt AdminStatusPage, 'application'

    then:
      waitFor { status('application').header.text() == 'APPLICATION' }
      status('application').rows[0].cells*.text() == ["applicationVersion", applicationVersion]
      status('application').rows[1].cells*.text() == ["commitHash", gitCommitHash]

    and:
      !status('health')
  }

  def "Status should be available as json feed"() {
    given:
      def applicationVersion = presentation.get(path: PathFixture.STATUS_APPLICATION_VERSION).data.applicationVersion
      def gitCommitHash = presentation.get(path: PathFixture.STATUS_COMMIT_HASH).data.commitHash

    when:
      def response = presentation.get(path: PathPresentation.API_1_STATUS, headers: ['Accept': 'application/json'])

    then:
      def status = response.data.status
      status[0] == [name: 'application', properties: [applicationVersion: applicationVersion, commitHash: gitCommitHash]]
      status[1] == [name: 'health', properties: [up: 'OK']]
  }

  def "Status should be available as json feed by section"() {
    given:
      def applicationVersion = presentation.get(path: PathFixture.STATUS_APPLICATION_VERSION).data.applicationVersion
      def gitCommitHash = presentation.get(path: PathFixture.STATUS_COMMIT_HASH).data.commitHash

    when:
      def response = presentation.get(path: "${PathPresentation.API_1_STATUS}/application", headers: ['Accept': 'application/json'])

    then:
      def status = response.data.status
      status[0] == [name: 'application', properties: [applicationVersion: applicationVersion, commitHash: gitCommitHash]]
      status[1] == null
  }
}
