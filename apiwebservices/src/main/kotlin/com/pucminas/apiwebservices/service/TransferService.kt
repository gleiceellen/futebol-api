package com.pucminas.apiwebservices.service

import com.pucminas.apiwebservices.exception.TransferCreateException
import com.pucminas.apiwebservices.model.Transfer
import com.pucminas.apiwebservices.model.request.PlayerUpdateDto
import com.pucminas.apiwebservices.model.request.TransferInsertDto
import com.pucminas.apiwebservices.repository.TransferRepository
import org.springframework.stereotype.Service

@Service
class TransferService(
    private val transferRepository: TransferRepository,
    private val playerService: PlayerService,
    private val clubService: ClubService,
) {
    fun createTransfer(transferInsertDto: TransferInsertDto): Transfer {

        val player = playerService.getPlayer(transferInsertDto.playerId)
            ?: throw TransferCreateException(TransferCreateException.PLAYER_NOT_FOUND)

        val originClub = clubService.getClub(transferInsertDto.originClubId)
            ?: throw TransferCreateException(TransferCreateException.ORIGIN_CLUB_NOT_FOUND)

        val destinationClub = clubService.getClub(transferInsertDto.destinationClubId)
            ?: throw TransferCreateException(TransferCreateException.DESTINATION_CLUB_NOT_FOUND)

        clubService.removePlayerFromClub(originClub.id!!, player.id!!)
        clubService.addPlayerToClub(destinationClub, player)

        val transfer = Transfer(
                player = player,
                destinationClub = destinationClub,
                originClub = originClub,
                date = transferInsertDto.date,
                amount = transferInsertDto.amount
        )

        return transferRepository.save(transfer)
    }

    fun getTransfers(): List<Transfer> {
        return transferRepository.findAll()
    }

    fun getTransfer(transferId: Long): Transfer? {
        val search = transferRepository.findById(transferId)
        return if(search.isPresent)
            search.get()
        else
            null
    }
}