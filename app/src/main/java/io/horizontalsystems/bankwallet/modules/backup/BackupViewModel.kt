package io.horizontalsystems.bankwallet.modules.backup

import androidx.lifecycle.ViewModel
import io.horizontalsystems.bankwallet.SingleLiveEvent
import io.horizontalsystems.bankwallet.entities.Account

class BackupViewModel : ViewModel(), BackupModule.View, BackupModule.Router {

    lateinit var delegate: BackupModule.ViewDelegate

    val startPinModuleEvent = SingleLiveEvent<Void>()
    val startBackupEvent = SingleLiveEvent<Account>()
    val closeLiveEvent = SingleLiveEvent<Void>()

    fun init(account: Account) {
        BackupModule.init(this, this, account)
    }

    // router

    override fun startUnlockPinModule() {
        startPinModuleEvent.call()
    }

    override fun startBackupModule(account: Account) {
        startBackupEvent.value = account
    }

    override fun close() {
        closeLiveEvent.call()
    }
}
